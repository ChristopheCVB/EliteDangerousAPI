package com.christophecvb.elitedangerous;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.events.StatusEvent;
import com.christophecvb.elitedangerous.events.backpack.*;
import com.christophecvb.elitedangerous.events.book.BookDropshipEvent;
import com.christophecvb.elitedangerous.events.book.BookTaxiEvent;
import com.christophecvb.elitedangerous.events.book.CancelDropshipEvent;
import com.christophecvb.elitedangerous.events.book.CancelTaxiEvent;
import com.christophecvb.elitedangerous.events.buysell.*;
import com.christophecvb.elitedangerous.events.combat.*;
import com.christophecvb.elitedangerous.events.exploration.*;
import com.christophecvb.elitedangerous.events.fleetcarriers.*;
import com.christophecvb.elitedangerous.events.onfoot.DisembarkEvent;
import com.christophecvb.elitedangerous.events.onfoot.DropShipDeployEvent;
import com.christophecvb.elitedangerous.events.onfoot.EmbarkEvent;
import com.christophecvb.elitedangerous.events.onfoot.ScanOrganicEvent;
import com.christophecvb.elitedangerous.events.other.*;
import com.christophecvb.elitedangerous.events.powerplay.*;
import com.christophecvb.elitedangerous.events.squadron.*;
import com.christophecvb.elitedangerous.events.startup.*;
import com.christophecvb.elitedangerous.events.stationservices.*;
import com.christophecvb.elitedangerous.events.suit.*;
import com.christophecvb.elitedangerous.events.trade.*;
import com.christophecvb.elitedangerous.events.travel.*;
import com.christophecvb.elitedangerous.models.scan.Parent;
import com.christophecvb.elitedangerous.utils.GameFiles;
import com.christophecvb.elitedangerous.utils.deserializer.*;
import com.google.gson.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class EliteDangerousAPI {
	public static Gson GSON;// TODO: I don't like this GSON being static

	static {
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
		eventDeserializer.registerEventType(BackpackEvent.class);
		eventDeserializer.registerEventType(BackpackChangeEvent.class);
		eventDeserializer.registerEventType(CollectItemsEvent.class);
		eventDeserializer.registerEventType(DropItemsEvent.class);
		eventDeserializer.registerEventType(BookDropshipEvent.class);
		eventDeserializer.registerEventType(BookTaxiEvent.class);
		eventDeserializer.registerEventType(CancelDropshipEvent.class);
		eventDeserializer.registerEventType(CancelTaxiEvent.class);
		eventDeserializer.registerEventType(BuyMicroResourcesEvent.class);
		eventDeserializer.registerEventType(BuySuitEvent.class);
		eventDeserializer.registerEventType(BuyWeaponEvent.class);
		eventDeserializer.registerEventType(DisembarkEvent.class);
		eventDeserializer.registerEventType(EmbarkEvent.class);
		eventDeserializer.registerEventType(DropShipDeployEvent.class);
		eventDeserializer.registerEventType(UseConsumableEvent.class);
		eventDeserializer.registerEventType(UpgradeWeaponEvent.class);
		eventDeserializer.registerEventType(UpgradeSuitEvent.class);
		eventDeserializer.registerEventType(TradeMicroResourcesEvent.class);
		eventDeserializer.registerEventType(SellSuitEvent.class);
		eventDeserializer.registerEventType(SellWeaponEvent.class);
		eventDeserializer.registerEventType(CreateSuitLoadoutEvent.class);
		eventDeserializer.registerEventType(DeleteSuitLoadoutEvent.class);
		eventDeserializer.registerEventType(LoadoutEquipModuleEvent.class);
		eventDeserializer.registerEventType(LoadoutRemoveModuleEvent.class);
		eventDeserializer.registerEventType(RenameSuitLoadoutEvent.class);
		eventDeserializer.registerEventType(ScanOrganicEvent.class);
		eventDeserializer.registerEventType(SellMicroResourcesEvent.class);
		eventDeserializer.registerEventType(SellOrganicDataEvent.class);
		eventDeserializer.registerEventType(ShipLockerMaterialsEvent.class);
		eventDeserializer.registerEventType(SwitchSuitLoadoutEvent.class);
		eventDeserializer.registerEventType(TransferMicroResourcesEvent.class);

		DiedEventDeserializer diedEventDeserializer = new DiedEventDeserializer();
		ParentDeserializer parentDeserializer = new ParentDeserializer();
		BountyEventDeserializer bountyEventDeserializer = new BountyEventDeserializer();
		ScanEventDeserializer scanEventDeserializer = new ScanEventDeserializer();
		ShipTargettedEventDeserializer shipTargettedEventDeserializer = new ShipTargettedEventDeserializer();

		EliteDangerousAPI.GSON = new GsonBuilder()
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

	private boolean active = false;
	private File journalFile;
	private RandomAccessFile randomAccessFile;
	private Thread journalReaderThread;
	private ScheduledExecutorService scheduledExecutorService;
	private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();
	private Date triggerEventsSince;

	private Thread createJournalReaderThread() {
		return new Thread(() -> {
			while (this.active) {
				File latestJournalFile = GameFiles.getLatestJournalFile();
				if (latestJournalFile == null) {
					File gameFilesDirectory = GameFiles.getDirectory();
					System.out.println("Game Files Directory exists: " + gameFilesDirectory.exists());
					System.out.println("Journal File does not exists in: " + gameFilesDirectory.getAbsolutePath());
					try {
						Thread.sleep(4000);
					}
					catch (InterruptedException ignored) {}
				}
				else {
					if (!latestJournalFile.equals(this.journalFile)) {
						this.journalFile = latestJournalFile;
						this.randomAccessFile = null;
					}

					if (this.randomAccessFile == null) {
						try {
							this.randomAccessFile = new RandomAccessFile(this.journalFile, "r");
						}
						catch (FileNotFoundException ignored) {}
					}

					try {
						if (this.randomAccessFile != null) {
							String rawEvent = this.randomAccessFile.readLine();
							if (rawEvent != null) {
								JsonObject jsonEvent = JsonParser.parseString(new String(rawEvent.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();

								Event event = this.parseEvent(jsonEvent);
								if (event != null) {
									this.triggerEventIfNeededSafely(event);
								}
							}
							else {
								// Game is creating another file, give it some time
								try {
									Thread.sleep(500);
								}
								catch (InterruptedException ignored) {}
							}
						}
						else {
							System.out.println("RandomAccessFile File could not be created");
						}
					}
					catch (IOException | JsonSyntaxException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	protected  <T extends Event> void triggerEventIfNeededSafely(T event) {
		if (event.timestamp.after(this.triggerEventsSince)) {
			Class<? extends Event> eventClass = event.getClass();
			if (this.listeners.containsKey(eventClass)) {
				try {
					this.listeners.get(event.getClass()).onTriggered(event);
				}
				catch (Exception ignored) {}
			}
			else {
				Class<?> eventSuperClass = eventClass.getSuperclass();
				while (!eventSuperClass.equals(Event.class)) {
					if (this.listeners.containsKey(eventSuperClass)) {
						try {
							this.listeners.get(eventSuperClass).onTriggered(event);
						}
						catch (Exception ignored) {}
						break;
					}
					eventSuperClass = eventSuperClass.getSuperclass();
				}
			}
		}
	}

	private void triggerStatusEventIfNeeded() {
		if (this.listeners.containsKey(StatusEvent.class)) {
			StatusEvent statusEvent = StatusEvent.loadFromFile();
			if (statusEvent != null) {
				this.triggerEventIfNeededSafely(statusEvent);
			}
		}
	}

	private EliteDangerousAPI() {
	}

	public boolean isActive() {
		return this.active && this.journalReaderThread != null && this.journalReaderThread.isAlive();
	}

	public void stop() {
		this.active = false;
		this.journalReaderThread = null;
		if (this.scheduledExecutorService != null) {
			this.scheduledExecutorService.shutdownNow();
			this.scheduledExecutorService = null;
		}
	}

	public void start() {
		this.active = true;
		if (this.journalReaderThread == null) {
			this.journalReaderThread = this.createJournalReaderThread();
		}
		if (!this.journalReaderThread.isAlive()) {
			this.journalReaderThread.start();
		}
		if (this.scheduledExecutorService != null) {
			this.scheduledExecutorService.shutdownNow();
		}
		this.scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		this.scheduledExecutorService.scheduleWithFixedDelay(this::triggerStatusEventIfNeeded, 0, 500, TimeUnit.MILLISECONDS);
	}

	protected Event parseEvent(JsonObject jsonEvent) {
		Event event = null;
		try {
			event = EliteDangerousAPI.GSON.fromJson(jsonEvent, Event.class);
		}
		catch (JsonSyntaxException ignored) {}

		if (event == null) {
			GameFiles.onUnprocessedEvent(jsonEvent);
		}

		return event;
	}

	public Date getTriggerEventsSince() {
		return this.triggerEventsSince;
	}

	public static class Builder {
		private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();
		private Date triggerEventsSince = new Date(0);

		public Builder() {
		}

		/**
		 * Add an {@link Event} Listener
		 *
		 * @param eventClass Class&lt;T&gt;
		 * @param listener   T.Listener
		 * @param <T>        Class&lt;T extends Event&gt;
		 * @return Builder builder
		 */
		public <T extends Event> Builder addEventListener(Class<T> eventClass, T.Listener listener) {
			this.listeners.put(eventClass, listener);

			return this;
		}

		/**
		 * Set the Trigger Events Since
		 *
		 * @param triggerEventsSince Date
		 * @return Builder builder
		 */
		public Builder setTriggerEventsSince(Date triggerEventsSince) {
			this.triggerEventsSince = triggerEventsSince;

			return this;
		}

		/**
		 * Instantiate the {@link EliteDangerousAPI} class and returns it for further use.
		 *
		 * @return The populated {@link EliteDangerousAPI} class
		 */
		public EliteDangerousAPI build() {
			EliteDangerousAPI eliteDangerousAPI = new EliteDangerousAPI();

			eliteDangerousAPI.listeners.putAll(this.listeners);
			eliteDangerousAPI.triggerEventsSince = this.triggerEventsSince;

			return eliteDangerousAPI;
		}
	}
}
