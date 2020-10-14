package com.github.ChristopheCVB.EliteDangerous;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.StatusEvent;
import com.github.ChristopheCVB.EliteDangerous.events.combat.*;
import com.github.ChristopheCVB.EliteDangerous.events.exploration.*;
import com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers.*;
import com.github.ChristopheCVB.EliteDangerous.events.other.*;
import com.github.ChristopheCVB.EliteDangerous.events.powerplay.*;
import com.github.ChristopheCVB.EliteDangerous.events.squadron.*;
import com.github.ChristopheCVB.EliteDangerous.events.startup.*;
import com.github.ChristopheCVB.EliteDangerous.events.stationservices.*;
import com.github.ChristopheCVB.EliteDangerous.events.trade.*;
import com.github.ChristopheCVB.EliteDangerous.events.travel.*;
import com.github.ChristopheCVB.EliteDangerous.models.scan.Parent;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFiles;
import com.github.ChristopheCVB.EliteDangerous.utils.deserializer.*;
import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class EliteDangerousAPI {
	private final String[] SUPPORTED_VERSIONS = new String[]{"Fleet Carriers Update", "Fleet Carriers Update - Update 1", "Fleet Carriers Update - Patch 5"};

	private boolean active = false;
	private boolean isFirstLine = true;
	private File journalFile;
	private RandomAccessFile randomAccessFile;
	private final Gson gson;
	private Thread readerThread;
	private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();

	private Thread createReaderThread() {
		return new Thread(() -> {
			while (this.active) {
				File latestJournalFile = GameFiles.getLatestJournalFile();
				if (latestJournalFile != null && !latestJournalFile.equals(this.journalFile)) {
					this.journalFile = latestJournalFile;
					this.randomAccessFile = null;
				}

				if (this.randomAccessFile == null) {
					if (this.journalFile != null) {
						try {
							this.randomAccessFile = new RandomAccessFile(this.journalFile, "r");
						}
						catch (FileNotFoundException ignored) {}
					}
					else {
						System.out.println("Journal File does not exists");
					}
				}

				try {
					if (this.randomAccessFile != null) {
						String rawEvent = this.randomAccessFile.readLine();
						if (rawEvent != null) {
							JsonObject jsonEvent = JsonParser.parseString(new String(rawEvent.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();

							if (this.isFirstLine) {
								this.isFirstLine = false;
								if (!isGameVersionSupported(jsonEvent)) {
									throw new UnsupportedOperationException("Game Version [" + jsonEvent.get("gameversion").getAsString() + "] is not supported");
								}
							}

							Event event = this.parseEvent(jsonEvent);
							if (event != null) {
								Class<? extends Event> eventClass = event.getClass();
								if (this.listeners.containsKey(eventClass)) {
									this.listeners.get(eventClass).onTriggered(event);
								}
								else {
									Class<?> eventSuperClass = eventClass.getSuperclass();
									while (!eventSuperClass.equals(Event.class)) {
										if (this.listeners.containsKey(eventSuperClass)) {
											this.listeners.get(eventSuperClass).onTriggered(event);
											break;
										}
										eventSuperClass = eventSuperClass.getSuperclass();
									}
								}
							}
						}
					}
					else {
						System.out.println("RandomAccessFile File cannot be created");
					}

					if (this.listeners.containsKey(StatusEvent.class)) {
						File statusFile = GameFiles.getStatusFile();
						if (statusFile != null) {
							String statusFileContent = new String(Files.readAllBytes(statusFile.toPath()), StandardCharsets.UTF_8);
							this.listeners.get(StatusEvent.class).onTriggered(this.gson.fromJson(statusFileContent, StatusEvent.class));
						}
					}
				}
				catch (UnsupportedOperationException unsupportedOperationException) {
					System.out.println(this.journalFile.getName() + " was created by an unsupported version, skipping for now...");
					EliteDangerousAPI.this.stop();
				}
				catch (IOException | JsonSyntaxException e) {
					e.printStackTrace();
				}

			}
		});
	}

	private EliteDangerousAPI() {
		EventDeserializer eventDeserializer = new EventDeserializer("event");
		eventDeserializer.registerEventType(SupercruiseEntryEvent.class);
		eventDeserializer.registerEventType(SupercruiseExitEvent.class);
		eventDeserializer.registerEventType(BountyEvent.class);
		eventDeserializer.registerEventType(CapShipBondEvent.class);
		eventDeserializer.registerEventType(DiedEvent.class);
		eventDeserializer.registerEventType(EscapeInterdictionEvent.class);
		eventDeserializer.registerEventType(FactionKillBondEvent.class);
		eventDeserializer.registerEventType(FighterDestroyedEvent.class);
		eventDeserializer.registerEventType(HeatDamageEvent.class);
		eventDeserializer.registerEventType(HeatWarningEvent.class);
		eventDeserializer.registerEventType(HullDamageEvent.class);
		eventDeserializer.registerEventType(InterdictedEvent.class);
		eventDeserializer.registerEventType(InterdictionEvent.class);
		eventDeserializer.registerEventType(PvPKillEvent.class);
		eventDeserializer.registerEventType(ShieldStateEvent.class);
		eventDeserializer.registerEventType(ShipTargettedEvent.class);
		eventDeserializer.registerEventType(SRVDestroyedEvent.class);
		eventDeserializer.registerEventType(UnderAttackEvent.class);
		eventDeserializer.registerEventType(MusicEvent.class);
		eventDeserializer.registerEventType(ReceiveTextEvent.class);
		eventDeserializer.registerEventType(BuyExplorationDataEvent.class);
		eventDeserializer.registerEventType(CodexEntryEvent.class);
		eventDeserializer.registerEventType(DiscoveryScanEvent.class);
		eventDeserializer.registerEventType(ScannedEvent.class);
		eventDeserializer.registerEventType(FSSAllBodiesFoundEvent.class);
		eventDeserializer.registerEventType(FSSDiscoveryScanEvent.class);
		eventDeserializer.registerEventType(FSSSignalDiscoveredEvent.class);
		eventDeserializer.registerEventType(MaterialCollectedEvent.class);
		eventDeserializer.registerEventType(MaterialDiscardedEvent.class);
		eventDeserializer.registerEventType(MaterialDiscoveredEvent.class);
		eventDeserializer.registerEventType(MultiSellExplorationDataEvent.class);
		eventDeserializer.registerEventType(NavBeaconScanEvent.class);
		eventDeserializer.registerEventType(SAAScanCompleteEvent.class);
		eventDeserializer.registerEventType(ScreenshotEvent.class);
		eventDeserializer.registerEventType(SellExplorationDataEvent.class);
		eventDeserializer.registerEventType(ApproachBodyEvent.class);
		eventDeserializer.registerEventType(ApproachSettlementEvent.class);
		eventDeserializer.registerEventType(DockedEvent.class);
		eventDeserializer.registerEventType(DockingCancelledEvent.class);
		eventDeserializer.registerEventType(DockingDeniedEvent.class);
		eventDeserializer.registerEventType(DockingGrantedEvent.class);
		eventDeserializer.registerEventType(DockingRequestedEvent.class);
		eventDeserializer.registerEventType(DockingTimeoutEvent.class);
		eventDeserializer.registerEventType(FSDJumpEvent.class);
		eventDeserializer.registerEventType(FSDTargetEvent.class);
		eventDeserializer.registerEventType(LeaveBodyEvent.class);
		eventDeserializer.registerEventType(LiftoffEvent.class);
		eventDeserializer.registerEventType(LocationEvent.class);
		eventDeserializer.registerEventType(StartJumpEvent.class);
		eventDeserializer.registerEventType(TouchdownEvent.class);
		eventDeserializer.registerEventType(UndockedEvent.class);
		eventDeserializer.registerEventType(AsteroidCrackedEvent.class);
		eventDeserializer.registerEventType(BuyTradeDataEvent.class);
		eventDeserializer.registerEventType(CollectCargoEvent.class);
		eventDeserializer.registerEventType(EjectCargoEvent.class);
		eventDeserializer.registerEventType(MarketBuyEvent.class);
		eventDeserializer.registerEventType(MarketSellEvent.class);
		eventDeserializer.registerEventType(MiningRefinedEvent.class);
		eventDeserializer.registerEventType(BuyAmmoEvent.class);
		eventDeserializer.registerEventType(BuyDronesEvent.class);
		eventDeserializer.registerEventType(CargoDepotEvent.class);
		eventDeserializer.registerEventType(CommunityGoalDiscardEvent.class);
		eventDeserializer.registerEventType(CommunityGoalEvent.class);
		eventDeserializer.registerEventType(CommunityGoalJoinEvent.class);
		eventDeserializer.registerEventType(CommunityGoalRewardEvent.class);
		eventDeserializer.registerEventType(CrewAssignEvent.class);
		eventDeserializer.registerEventType(CrewFireEvent.class);
		eventDeserializer.registerEventType(CrewHireEvent.class);
		eventDeserializer.registerEventType(EngineerContributionEvent.class);
		eventDeserializer.registerEventType(EngineerCraftEvent.class);
		eventDeserializer.registerEventType(EngineerProgressEvent.class);
		eventDeserializer.registerEventType(FetchRemoteModuleEvent.class);
		eventDeserializer.registerEventType(MarketEvent.class);
		eventDeserializer.registerEventType(MassModuleStoreEvent.class);
		eventDeserializer.registerEventType(MaterialTradeEvent.class);
		eventDeserializer.registerEventType(MissionAbandonedEvent.class);
		eventDeserializer.registerEventType(MissionAcceptedEvent.class);
		eventDeserializer.registerEventType(MissionCompletedEvent.class);
		eventDeserializer.registerEventType(MissionFailedEvent.class);
		eventDeserializer.registerEventType(MissionRedirectedEvent.class);
		eventDeserializer.registerEventType(ModuleBuyEvent.class);
		eventDeserializer.registerEventType(ModuleRetrieveEvent.class);
		eventDeserializer.registerEventType(ModuleSellEvent.class);
		eventDeserializer.registerEventType(ModuleSellRemoteEvent.class);
		eventDeserializer.registerEventType(ModuleStoreEvent.class);
		eventDeserializer.registerEventType(ModuleSwapEvent.class);
		eventDeserializer.registerEventType(OutfittingEvent.class);
		eventDeserializer.registerEventType(PayBountiesEvent.class);
		eventDeserializer.registerEventType(PayFinesEvent.class);
		eventDeserializer.registerEventType(RedeemVoucherEvent.class);
		eventDeserializer.registerEventType(RefuelAllEvent.class);
		eventDeserializer.registerEventType(RefuelPartialEvent.class);
		eventDeserializer.registerEventType(ClearSavedGameEvent.class);
		eventDeserializer.registerEventType(CommanderEvent.class);
		eventDeserializer.registerEventType(LoadGameEvent.class);
		eventDeserializer.registerEventType(NewCommanderEvent.class);
		eventDeserializer.registerEventType(ProgressEvent.class);
		eventDeserializer.registerEventType(CargoEvent.class);
		eventDeserializer.registerEventType(LoadoutEvent.class);
		eventDeserializer.registerEventType(MaterialsEvent.class);
		eventDeserializer.registerEventType(PassengersEvent.class);
		eventDeserializer.registerEventType(MissionsEvent.class);
		eventDeserializer.registerEventType(RankEvent.class);
		eventDeserializer.registerEventType(ReputationEvent.class);
		eventDeserializer.registerEventType(RepairAllEvent.class);
		eventDeserializer.registerEventType(RepairEvent.class);
		eventDeserializer.registerEventType(RestockVehicleEvent.class);
		eventDeserializer.registerEventType(ScientificResearchEvent.class);
		eventDeserializer.registerEventType(SearchAndRescueEvent.class);
		eventDeserializer.registerEventType(SellDronesEvent.class);
		eventDeserializer.registerEventType(SellShipOnRebuyEvent.class);
		eventDeserializer.registerEventType(SetUserShipNameEvent.class);
		eventDeserializer.registerEventType(ShipyardBuyEvent.class);
		eventDeserializer.registerEventType(ShipyardEvent.class);
		eventDeserializer.registerEventType(ShipyardNewEvent.class);
		eventDeserializer.registerEventType(ShipyardSellEvent.class);
		eventDeserializer.registerEventType(ShipyardSwapEvent.class);
		eventDeserializer.registerEventType(ShipyardTransferEvent.class);
		eventDeserializer.registerEventType(StoredModulesEvent.class);
		eventDeserializer.registerEventType(StoredShipsEvent.class);
		eventDeserializer.registerEventType(TechnologyBrokerEvent.class);
		eventDeserializer.registerEventType(CarrierBankTransferEvent.class);
		eventDeserializer.registerEventType(CarrierCrewServicesEvent.class);
		eventDeserializer.registerEventType(CarrierDepositFuelEvent.class);
		eventDeserializer.registerEventType(CarrierFinanceEvent.class);
		eventDeserializer.registerEventType(PowerplayEvent.class);
		eventDeserializer.registerEventType(CargoTransferEvent.class);
		eventDeserializer.registerEventType(StatisticsEvent.class);
		eventDeserializer.registerEventType(ScanEvent.class);
		eventDeserializer.registerEventType(NavRouteEvent.class);
		eventDeserializer.registerEventType(ReservoirReplenishedEvent.class);
		eventDeserializer.registerEventType(ModuleInfoEvent.class);
		eventDeserializer.registerEventType(PromotionEvent.class);
		eventDeserializer.registerEventType(USSDropEvent.class);
		eventDeserializer.registerEventType(ShutdownEvent.class);
		eventDeserializer.registerEventType(RouteEvent.class);
		eventDeserializer.registerEventType(CarrierJumpEvent.class);
		eventDeserializer.registerEventType(CarrierJumpCancelledEvent.class);
		eventDeserializer.registerEventType(AppliedToSquadronEvent.class);
		eventDeserializer.registerEventType(DisbandedSquadronEvent.class);
		eventDeserializer.registerEventType(InvitedToSquadronEvent.class);
		eventDeserializer.registerEventType(JoinedSquadronEvent.class);
		eventDeserializer.registerEventType(KickedFromSquadronEvent.class);
		eventDeserializer.registerEventType(LeftSquadronEvent.class);
		eventDeserializer.registerEventType(SharedBookmarkToSquadronEvent.class);
		eventDeserializer.registerEventType(SquadronCreatedEvent.class);
		eventDeserializer.registerEventType(SquadronDemotionEvent.class);
		eventDeserializer.registerEventType(SquadronPromotionEvent.class);
		eventDeserializer.registerEventType(SquadronStartupEvent.class);
		eventDeserializer.registerEventType(WonATrophyForSquadronEvent.class);
		eventDeserializer.registerEventType(CarrierBuyEvent.class);
		eventDeserializer.registerEventType(CarrierStatsEvent.class);
		eventDeserializer.registerEventType(CarrierJumpRequestEvent.class);
		eventDeserializer.registerEventType(CarrierDecommissionEvent.class);
		eventDeserializer.registerEventType(CarrierCancelDecommissionEvent.class);
		eventDeserializer.registerEventType(CarrierShipPackEvent.class);
		eventDeserializer.registerEventType(CarrierModulePackEvent.class);
		eventDeserializer.registerEventType(CarrierTradeOrderEvent.class);
		eventDeserializer.registerEventType(CarrierDockingPermissionEvent.class);
		eventDeserializer.registerEventType(CarrierNameChangedEvent.class);
		eventDeserializer.registerEventType(PowerplayCollectEvent.class);
		eventDeserializer.registerEventType(PowerplayDefectEvent.class);
		eventDeserializer.registerEventType(PowerplayDeliverEvent.class);
		eventDeserializer.registerEventType(PowerplayFastTrackEvent.class);
		eventDeserializer.registerEventType(PowerplayJoinEvent.class);
		eventDeserializer.registerEventType(PowerplayLeaveEvent.class);
		eventDeserializer.registerEventType(PowerplaySalaryEvent.class);
		eventDeserializer.registerEventType(PowerplayVoteEvent.class);
		eventDeserializer.registerEventType(PowerplayVoucherEvent.class);
		eventDeserializer.registerEventType(AfmuRepairsEvent.class);
		eventDeserializer.registerEventType(ChangeCrewRoleEvent.class);
		eventDeserializer.registerEventType(CockpitBreachedEvent.class);
		eventDeserializer.registerEventType(CommitCrimeEvent.class);
		eventDeserializer.registerEventType(ContinuedEvent.class);
		eventDeserializer.registerEventType(CrewLaunchFighterEvent.class);
		eventDeserializer.registerEventType(CrewMemberJoinsEvent.class);
		eventDeserializer.registerEventType(CrewMemberQuitsEvent.class);
		eventDeserializer.registerEventType(CrewMemberRoleChangeEvent.class);
		eventDeserializer.registerEventType(CrimeVictimEvent.class);
		eventDeserializer.registerEventType(DatalinkScanEvent.class);
		eventDeserializer.registerEventType(DatalinkVoucherEvent.class);
		eventDeserializer.registerEventType(DataScannedEvent.class);
		eventDeserializer.registerEventType(DockFighterEvent.class);
		eventDeserializer.registerEventType(DockSRVEvent.class);
		eventDeserializer.registerEventType(EndCrewSessionEvent.class);
		eventDeserializer.registerEventType(FighterRebuiltEvent.class);
		eventDeserializer.registerEventType(FuelScoopEvent.class);
		eventDeserializer.registerEventType(FriendsEvent.class);
		eventDeserializer.registerEventType(JetConeBoostEvent.class);
		eventDeserializer.registerEventType(JetConeDamageEvent.class);
		eventDeserializer.registerEventType(JoinACrewEvent.class);
		eventDeserializer.registerEventType(KickCrewMemberEvent.class);
		eventDeserializer.registerEventType(LaunchDroneEvent.class);
		eventDeserializer.registerEventType(LaunchFighterEvent.class);
		eventDeserializer.registerEventType(LaunchSRVEvent.class);
		eventDeserializer.registerEventType(NpcCrewPaidWageEvent.class);
		eventDeserializer.registerEventType(NpcCrewRankEvent.class);
		eventDeserializer.registerEventType(ProspectedAsteroidEvent.class);
		eventDeserializer.registerEventType(QuitACrewEvent.class);
		eventDeserializer.registerEventType(RebootRepairEvent.class);
		eventDeserializer.registerEventType(RepairDoneEvent.class);
		eventDeserializer.registerEventType(ResurrectEvent.class);
		eventDeserializer.registerEventType(SelfDestructEvent.class);
		eventDeserializer.registerEventType(SendTextEvent.class);
		eventDeserializer.registerEventType(SynthesisEvent.class);
		eventDeserializer.registerEventType(SystemsShutdownEvent.class);
		eventDeserializer.registerEventType(VehicleSwitchEvent.class);
		eventDeserializer.registerEventType(WingAddEvent.class);
		eventDeserializer.registerEventType(WingInviteEvent.class);
		eventDeserializer.registerEventType(WingJoinEvent.class);
		eventDeserializer.registerEventType(WingLeaveEvent.class);

		DiedEventDeserializer diedEventDeserializer = new DiedEventDeserializer();
		ParentDeserializer parentDeserializer = new ParentDeserializer();
		BountyEventDeserializer bountyEventDeserializer = new BountyEventDeserializer();
		ScanEventDeserializer scanEventDeserializer = new ScanEventDeserializer();
		ShipTargettedEventDeserializer shipTargettedEventDeserializer = new ShipTargettedEventDeserializer();

		this.gson = new GsonBuilder()
				.setFieldNamingStrategy(f -> FieldNamingPolicy.UPPER_CAMEL_CASE.translateName(f).replaceFirst("Localised$", "_Localised"))
				.registerTypeAdapter(Event.class, eventDeserializer)
				.registerTypeAdapter(DiedEvent.class, diedEventDeserializer)
				.registerTypeAdapter(Parent.class, parentDeserializer)
				.registerTypeAdapter(BountyEvent.class, bountyEventDeserializer)
				.registerTypeAdapter(ScanEvent.class, scanEventDeserializer)
				.registerTypeAdapter(ShipTargettedEvent.class, shipTargettedEventDeserializer)
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
				.create();
	}

	public boolean isActive() {
		return this.active && this.readerThread != null && this.readerThread.isAlive();
	}

	public void stop() {
		this.active = false;
		this.readerThread = null;
	}

	public void start() {
		this.active = true;
		if (this.readerThread == null) {
			this.readerThread = this.createReaderThread();
		}
		if (!this.readerThread.isAlive()) {
			this.readerThread.start();
		}
	}

	private Boolean isGameVersionSupported(JsonObject jsonEvent) {
		String gameVersionName = jsonEvent.get("gameversion").getAsString();
		for (String version : SUPPORTED_VERSIONS) {
			if (version.equalsIgnoreCase(gameVersionName)) {
				return true;
			}
		}
		return false;
	}

	private Event parseEvent(JsonObject jsonEvent) {
		Event event = null;
		try {
			event = this.gson.fromJson(jsonEvent, Event.class);
		}
		catch (JsonSyntaxException ignored) {}

		if (event == null) {
			GameFiles.onUnprocessedEvent(jsonEvent);
		}

		return event;
	}

	public static class Builder {
		private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();

		public <T extends Event> Builder addEventListener(Class<T> eventClass, T.Listener listener) {
			this.listeners.put(eventClass, listener);

			return this;
		}

		/**
		 * Populates the {@link EliteDangerousAPI} class and returns it for further use.
		 *
		 * @return The populated {@link EliteDangerousAPI} class
		 */
		public EliteDangerousAPI build() {
			EliteDangerousAPI eliteDangerousAPI = new EliteDangerousAPI();

			eliteDangerousAPI.listeners.putAll(this.listeners);

			return eliteDangerousAPI;
		}
	}
}
