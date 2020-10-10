package com.github.ChristopheCVB.EliteDangerous;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.MusicEvent;
import com.github.ChristopheCVB.EliteDangerous.events.ReceiveTextEvent;
import com.github.ChristopheCVB.EliteDangerous.events.combat.*;
import com.github.ChristopheCVB.EliteDangerous.events.exploration.*;
import com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier.CarrierBankTransferEvent;
import com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier.CarrierCrewServicesEvent;
import com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier.CarrierDepositFuelEvent;
import com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier.CarrierFinanceEvent;
import com.github.ChristopheCVB.EliteDangerous.events.inventory.CargoTransferEvent;
import com.github.ChristopheCVB.EliteDangerous.events.startup.*;
import com.github.ChristopheCVB.EliteDangerous.events.stationservices.*;
import com.github.ChristopheCVB.EliteDangerous.events.trade.*;
import com.github.ChristopheCVB.EliteDangerous.events.travel.*;
import com.github.ChristopheCVB.EliteDangerous.states.Status;
import com.github.ChristopheCVB.EliteDangerous.states.StatusListener;
import com.github.ChristopheCVB.EliteDangerous.utils.DiedEventDeserializer;
import com.github.ChristopheCVB.EliteDangerous.utils.EventDeserializer;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.exceptions.UnsupportedGameVersion;
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
	private StatusListener statusListener;

	private Thread createReaderThread() {
		return new Thread(() -> {
			while (this.active) {
				File latestJournalFile = GameFilesUtils.getLatestJournalFile();
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
									throw new UnsupportedGameVersion();
								}
							}

							Event event = this.parseEvent(jsonEvent);
							if (event != null && this.listeners.containsKey(event.getClass())) {
								this.listeners.get(event.getClass()).onTriggered(event);
							}
						}
					}
					else {
						System.out.println("RandomAccessFile File cannot be created");
					}

					if (this.statusListener != null) {
						File statusFile = GameFilesUtils.getStatusFile();
						if (statusFile != null) {
							String statusFileContent = new String(Files.readAllBytes(statusFile.toPath()), StandardCharsets.UTF_8);
							this.statusListener.onStatus(this.gson.fromJson(statusFileContent, Status.class));
						}
					}
				}
				catch (UnsupportedGameVersion unsupportedGameVersion) {
					System.out.println(this.journalFile.getName() + " was created by an unsupported version, skipping for now...");
				}
				catch (IOException | JsonSyntaxException e) {
					e.printStackTrace();
				}

			}
		});
	}

	private EliteDangerousAPI() {
		EventDeserializer eventDeserializer = new EventDeserializer("event");
		eventDeserializer.registerEventType(SupercruiseEntryEvent.class.getSimpleName().replace("Event", ""), SupercruiseEntryEvent.class);
		eventDeserializer.registerEventType(SupercruiseExitEvent.class.getSimpleName().replace("Event", ""), SupercruiseExitEvent.class);
		eventDeserializer.registerEventType(BountyEvent.class.getSimpleName().replace("Event", ""), BountyEvent.class);
		eventDeserializer.registerEventType(CapShipBondEvent.class.getSimpleName().replace("Event", ""), CapShipBondEvent.class);
		eventDeserializer.registerEventType(DiedEvent.class.getSimpleName().replace("Event", ""), DiedEvent.class);
		eventDeserializer.registerEventType(EscapeInterdictionEvent.class.getSimpleName().replace("Event", ""), EscapeInterdictionEvent.class);
		eventDeserializer.registerEventType(FactionKillBondEvent.class.getSimpleName().replace("Event", ""), FactionKillBondEvent.class);
		eventDeserializer.registerEventType(FighterDestroyedEvent.class.getSimpleName().replace("Event", ""), FighterDestroyedEvent.class);
		eventDeserializer.registerEventType(HeatDamageEvent.class.getSimpleName().replace("Event", ""), HeatDamageEvent.class);
		eventDeserializer.registerEventType(HeatWarningEvent.class.getSimpleName().replace("Event", ""), HeatWarningEvent.class);
		eventDeserializer.registerEventType(HullDamageEvent.class.getSimpleName().replace("Event", ""), HullDamageEvent.class);
		eventDeserializer.registerEventType(InterdictedEvent.class.getSimpleName().replace("Event", ""), InterdictedEvent.class);
		eventDeserializer.registerEventType(InterdictionEvent.class.getSimpleName().replace("Event", ""), InterdictionEvent.class);
		eventDeserializer.registerEventType(PvPKillEvent.class.getSimpleName().replace("Event", ""), PvPKillEvent.class);
		eventDeserializer.registerEventType(ShieldStateEvent.class.getSimpleName().replace("Event", ""), ShieldStateEvent.class);
		eventDeserializer.registerEventType(ShipTargetedEvent.class.getSimpleName().replace("Event", ""), ShipTargetedEvent.class);
		eventDeserializer.registerEventType(SRVDestroyedEvent.class.getSimpleName().replace("Event", ""), SRVDestroyedEvent.class);
		eventDeserializer.registerEventType(UnderAttackEvent.class.getSimpleName().replace("Event", ""), UnderAttackEvent.class);
		eventDeserializer.registerEventType(MusicEvent.class.getSimpleName().replace("Event", ""), MusicEvent.class);
		eventDeserializer.registerEventType(ReceiveTextEvent.class.getSimpleName().replace("Event", ""), ReceiveTextEvent.class);
		eventDeserializer.registerEventType(BuyExplorationDataEvent.class.getSimpleName().replace("Event", ""), BuyExplorationDataEvent.class);
		eventDeserializer.registerEventType(CodexEntryEvent.class.getSimpleName().replace("Event", ""), CodexEntryEvent.class);
		eventDeserializer.registerEventType(DiscoveryScanEvent.class.getSimpleName().replace("Event", ""), DiscoveryScanEvent.class);
		eventDeserializer.registerEventType(FSSAllBodiesFoundEvent.class.getSimpleName().replace("Event", ""), FSSAllBodiesFoundEvent.class);
		eventDeserializer.registerEventType(FSSDiscoveryScanEvent.class.getSimpleName().replace("Event", ""), FSSDiscoveryScanEvent.class);
		eventDeserializer.registerEventType(FSSSignalDiscoveredEvent.class.getSimpleName().replace("Event", ""), FSSSignalDiscoveredEvent.class);
		eventDeserializer.registerEventType(MaterialCollectedEvent.class.getSimpleName().replace("Event", ""), MaterialCollectedEvent.class);
		eventDeserializer.registerEventType(MaterialDiscardedEvent.class.getSimpleName().replace("Event", ""), MaterialDiscardedEvent.class);
		eventDeserializer.registerEventType(MaterialDiscoveredEvent.class.getSimpleName().replace("Event", ""), MaterialDiscoveredEvent.class);
		eventDeserializer.registerEventType(MultiSellExplorationDataEvent.class.getSimpleName().replace("Event", ""), MultiSellExplorationDataEvent.class);
		eventDeserializer.registerEventType(NavBeaconScanEvent.class.getSimpleName().replace("Event", ""), NavBeaconScanEvent.class);
		eventDeserializer.registerEventType(SAAScanCompleteEvent.class.getSimpleName().replace("Event", ""), SAAScanCompleteEvent.class);
		eventDeserializer.registerEventType(ScreenshotEvent.class.getSimpleName().replace("Event", ""), ScreenshotEvent.class);
		eventDeserializer.registerEventType(SellExplorationDataEvent.class.getSimpleName().replace("Event", ""), SellExplorationDataEvent.class);
		eventDeserializer.registerEventType(ApproachBodyEvent.class.getSimpleName().replace("Event", ""), ApproachBodyEvent.class);
		eventDeserializer.registerEventType(ApproachSettlementEvent.class.getSimpleName().replace("Event", ""), ApproachSettlementEvent.class);
		eventDeserializer.registerEventType(DockedEvent.class.getSimpleName().replace("Event", ""), DockedEvent.class);
		eventDeserializer.registerEventType(DockingCancelledEvent.class.getSimpleName().replace("Event", ""), DockingCancelledEvent.class);
		eventDeserializer.registerEventType(DockingDeniedEvent.class.getSimpleName().replace("Event", ""), DockingDeniedEvent.class);
		eventDeserializer.registerEventType(DockingGrantedEvent.class.getSimpleName().replace("Event", ""), DockingGrantedEvent.class);
		eventDeserializer.registerEventType(DockingRequestedEvent.class.getSimpleName().replace("Event", ""), DockingRequestedEvent.class);
		eventDeserializer.registerEventType(FSDJumpEvent.class.getSimpleName().replace("Event", ""), FSDJumpEvent.class);
		eventDeserializer.registerEventType(FSDTargetEvent.class.getSimpleName().replace("Event", ""), FSDTargetEvent.class);
		eventDeserializer.registerEventType(LeaveBodyEvent.class.getSimpleName().replace("Event", ""), LeaveBodyEvent.class);
		eventDeserializer.registerEventType(LiftoffEvent.class.getSimpleName().replace("Event", ""), LiftoffEvent.class);
		eventDeserializer.registerEventType(LocationEvent.class.getSimpleName().replace("Event", ""), LocationEvent.class);
		eventDeserializer.registerEventType(StartJumpEvent.class.getSimpleName().replace("Event", ""), StartJumpEvent.class);
		eventDeserializer.registerEventType(TouchdownEvent.class.getSimpleName().replace("Event", ""), TouchdownEvent.class);
		eventDeserializer.registerEventType(UndockedEvent.class.getSimpleName().replace("Event", ""), UndockedEvent.class);
		eventDeserializer.registerEventType(ApproachBodyEvent.class.getSimpleName().replace("Event", ""), ApproachBodyEvent.class);
		eventDeserializer.registerEventType(ApproachSettlementEvent.class.getSimpleName().replace("Event", ""), ApproachSettlementEvent.class);
		eventDeserializer.registerEventType(DockedEvent.class.getSimpleName().replace("Event", ""), DockedEvent.class);
		eventDeserializer.registerEventType(DockingCancelledEvent.class.getSimpleName().replace("Event", ""), DockingCancelledEvent.class);
		eventDeserializer.registerEventType(DockingDeniedEvent.class.getSimpleName().replace("Event", ""), DockingDeniedEvent.class);
		eventDeserializer.registerEventType(DockingGrantedEvent.class.getSimpleName().replace("Event", ""), DockingGrantedEvent.class);
		eventDeserializer.registerEventType(DockingRequestedEvent.class.getSimpleName().replace("Event", ""), DockingRequestedEvent.class);
		eventDeserializer.registerEventType(FSDJumpEvent.class.getSimpleName().replace("Event", ""), FSDJumpEvent.class);
		eventDeserializer.registerEventType(FSDTargetEvent.class.getSimpleName().replace("Event", ""), FSDTargetEvent.class);
		eventDeserializer.registerEventType(LeaveBodyEvent.class.getSimpleName().replace("Event", ""), LeaveBodyEvent.class);
		eventDeserializer.registerEventType(LiftoffEvent.class.getSimpleName().replace("Event", ""), LiftoffEvent.class);
		eventDeserializer.registerEventType(LocationEvent.class.getSimpleName().replace("Event", ""), LocationEvent.class);
		eventDeserializer.registerEventType(StartJumpEvent.class.getSimpleName().replace("Event", ""), StartJumpEvent.class);
		eventDeserializer.registerEventType(TouchdownEvent.class.getSimpleName().replace("Event", ""), TouchdownEvent.class);
		eventDeserializer.registerEventType(UndockedEvent.class.getSimpleName().replace("Event", ""), UndockedEvent.class);
		eventDeserializer.registerEventType(AsteroidCrackedEvent.class.getSimpleName().replace("Event", ""), AsteroidCrackedEvent.class);
		eventDeserializer.registerEventType(BuyTradeDataEvent.class.getSimpleName().replace("Event", ""), BuyTradeDataEvent.class);
		eventDeserializer.registerEventType(CollectCargoEvent.class.getSimpleName().replace("Event", ""), CollectCargoEvent.class);
		eventDeserializer.registerEventType(EjectCargoEvent.class.getSimpleName().replace("Event", ""), EjectCargoEvent.class);
		eventDeserializer.registerEventType(MarketBuyEvent.class.getSimpleName().replace("Event", ""), MarketBuyEvent.class);
		eventDeserializer.registerEventType(MarketSellEvent.class.getSimpleName().replace("Event", ""), MarketSellEvent.class);
		eventDeserializer.registerEventType(MiningRefinedEvent.class.getSimpleName().replace("Event", ""), MiningRefinedEvent.class);
		eventDeserializer.registerEventType(BuyAmmoEvent.class.getSimpleName().replace("Event", ""), BuyAmmoEvent.class);
		eventDeserializer.registerEventType(BuyDronesEvent.class.getSimpleName().replace("Event", ""), BuyDronesEvent.class);
		eventDeserializer.registerEventType(CargoDepotEvent.class.getSimpleName().replace("Event", ""), CargoDepotEvent.class);
		eventDeserializer.registerEventType(CommunityGoalDiscardEvent.class.getSimpleName().replace("Event", ""), CommunityGoalDiscardEvent.class);
		eventDeserializer.registerEventType(CommunityGoalEvent.class.getSimpleName().replace("Event", ""), CommunityGoalEvent.class);
		eventDeserializer.registerEventType(CommunityGoalJoinEvent.class.getSimpleName().replace("Event", ""), CommunityGoalJoinEvent.class);
		eventDeserializer.registerEventType(CommunityGoalRewardEvent.class.getSimpleName().replace("Event", ""), CommunityGoalRewardEvent.class);
		eventDeserializer.registerEventType(CrewAssignEvent.class.getSimpleName().replace("Event", ""), CrewAssignEvent.class);
		eventDeserializer.registerEventType(CrewFireEvent.class.getSimpleName().replace("Event", ""), CrewFireEvent.class);
		eventDeserializer.registerEventType(CrewHireEvent.class.getSimpleName().replace("Event", ""), CrewHireEvent.class);
		eventDeserializer.registerEventType(EngineerContributionEvent.class.getSimpleName().replace("Event", ""), EngineerContributionEvent.class);
		eventDeserializer.registerEventType(EngineerCraftEvent.class.getSimpleName().replace("Event", ""), EngineerCraftEvent.class);
		eventDeserializer.registerEventType(EngineerProgressEvent.class.getSimpleName().replace("Event", ""), EngineerProgressEvent.class);
		eventDeserializer.registerEventType(FetchRemoteModuleEvent.class.getSimpleName().replace("Event", ""), FetchRemoteModuleEvent.class);
		eventDeserializer.registerEventType(MarketEvent.class.getSimpleName().replace("Event", ""), MarketEvent.class);
		eventDeserializer.registerEventType(MassModuleStoreEvent.class.getSimpleName().replace("Event", ""), MassModuleStoreEvent.class);
		eventDeserializer.registerEventType(MaterialTradeEvent.class.getSimpleName().replace("Event", ""), MaterialTradeEvent.class);
		eventDeserializer.registerEventType(MissionAbandonedEvent.class.getSimpleName().replace("Event", ""), MissionAbandonedEvent.class);
		eventDeserializer.registerEventType(MissionAcceptedEvent.class.getSimpleName().replace("Event", ""), MissionAcceptedEvent.class);
		eventDeserializer.registerEventType(MissionCompletedEvent.class.getSimpleName().replace("Event", ""), MissionCompletedEvent.class);
		eventDeserializer.registerEventType(MissionFailedEvent.class.getSimpleName().replace("Event", ""), MissionFailedEvent.class);
		eventDeserializer.registerEventType(MissionRedirectedEvent.class.getSimpleName().replace("Event", ""), MissionRedirectedEvent.class);
		eventDeserializer.registerEventType(ModuleBuyEvent.class.getSimpleName().replace("Event", ""), ModuleBuyEvent.class);
		eventDeserializer.registerEventType(ModuleRetrieveEvent.class.getSimpleName().replace("Event", ""), ModuleRetrieveEvent.class);
		eventDeserializer.registerEventType(ModuleSellEvent.class.getSimpleName().replace("Event", ""), ModuleSellEvent.class);
		eventDeserializer.registerEventType(ModuleSellRemoteEvent.class.getSimpleName().replace("Event", ""), ModuleSellRemoteEvent.class);
		eventDeserializer.registerEventType(ModuleStoreEvent.class.getSimpleName().replace("Event", ""), ModuleStoreEvent.class);
		eventDeserializer.registerEventType(ModuleSwapEvent.class.getSimpleName().replace("Event", ""), ModuleSwapEvent.class);
		eventDeserializer.registerEventType(OutfittingEvent.class.getSimpleName().replace("Event", ""), OutfittingEvent.class);
		eventDeserializer.registerEventType(PayBountiesEvent.class.getSimpleName().replace("Event", ""), PayBountiesEvent.class);
		eventDeserializer.registerEventType(PayFinesEvent.class.getSimpleName().replace("Event", ""), PayFinesEvent.class);
		eventDeserializer.registerEventType(RedeemVoucherEvent.class.getSimpleName().replace("Event", ""), RedeemVoucherEvent.class);
		eventDeserializer.registerEventType(RefuelAllEvent.class.getSimpleName().replace("Event", ""), RefuelAllEvent.class);
		eventDeserializer.registerEventType(RefuelPartialEvent.class.getSimpleName().replace("Event", ""), RefuelPartialEvent.class);

		DiedEventDeserializer diedEventDeserializer = new DiedEventDeserializer();

		this.gson = new GsonBuilder()
				.setFieldNamingStrategy(f -> FieldNamingPolicy.UPPER_CAMEL_CASE.translateName(f).replaceFirst("Localised$", "_Localised"))
				.registerTypeAdapter(Event.class, eventDeserializer)
				.registerTypeAdapter(DiedEvent.class, diedEventDeserializer)
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
				.create();
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

	private Boolean isGameVersionSupported(JsonObject json) {
		String gameVersionName = JsonUtils.pullString(json, "gameversion");
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
			if (event != null) {
				return event;
			}
		}
		catch (JsonSyntaxException ignored) {}

		String timestamp = JsonUtils.pullString(jsonEvent, "timestamp");
		String eventName = JsonUtils.pullString(jsonEvent, "event");

		switch (eventName) {
			case "Cargo":
				if (jsonEvent.has("Inventory")) {
					event = new CargoEvent(timestamp, jsonEvent);
				}
				break;
			case "ClearSavedGame":
				event = new ClearSavedGameEvent(timestamp, jsonEvent);
				break;
			case "Commander":
				event = new CommanderEvent(timestamp, jsonEvent);
				break;
			case "Loadout":
				event = new LoadoutEvent(timestamp, jsonEvent);
				break;
			case "Materials":
				event = new MaterialsEvent(timestamp, jsonEvent);
				break;
			case "Missions":
				event = new MissionsEvent(timestamp, jsonEvent);
				break;
			case "NewCommander":
				event = new NewCommanderEvent(timestamp, jsonEvent);
				break;
			case "LoadGame":
				event = new LoadGameEvent(timestamp, jsonEvent);
				break;
			case "Passengers":
				event = new PassengersEvent(timestamp, jsonEvent);
				break;
			case "Powerplay":
				event = new PowerplayEvent(timestamp, jsonEvent);
				break;
			case "Progress":
				event = new ProgressEvent(timestamp, jsonEvent);
				break;
			case "Rank":
				event = new RankEvent(timestamp, jsonEvent);
				break;
			case "Reputation":
				event = new ReputationEvent(timestamp, jsonEvent);
				break;
			case "Statistics":
				event = new StatisticsEvent(timestamp, jsonEvent);
				break;
			case "Scan":
				event = new ScanEvent(timestamp, jsonEvent);
				break;
			case "Repair":
				event = new RepairEvent(timestamp, jsonEvent);
				break;
			case "RepairAll":
				event = new RepairAllEvent(timestamp, jsonEvent);
				break;
			case "RestockVehicle":
				event = new RestockVehicleEvent(timestamp, jsonEvent);
				break;
			case "ScientificResearch":
				event = new ScientificResearchEvent(timestamp, jsonEvent);
				break;
			case "SearchAndRescue":
				event = new SearchAndRescueEvent(timestamp, jsonEvent);
				break;
			case "SellDrones":
				event = new SellDronesEvent(timestamp, jsonEvent);
				break;
			case "SellShipOnRebuy":
				event = new SellShipOnRebuyEvent(timestamp, jsonEvent);
				break;
			case "SetUserShipName":
				event = new SetUserShipNameEvent(timestamp, jsonEvent);
				break;
			case "Shipyard":
				event = new ShipyardEvent(timestamp, jsonEvent);
				break;
			case "ShipyardBuy":
				event = new ShipyardBuyEvent(timestamp, jsonEvent);
				break;
			case "ShipyardNew":
				event = new ShipyardNewEvent(timestamp, jsonEvent);
				break;
			case "ShipyardSell":
				event = new ShipyardSellEvent(timestamp, jsonEvent);
				break;
			case "ShipyardTransfer":
				event = new ShipyardTransferEvent(timestamp, jsonEvent);
				break;
			case "ShipyardSwap":
				event = new ShipyardSwapEvent(timestamp, jsonEvent);
				break;
			case "StoredModules":
				event = new StoredModulesEvent(timestamp, jsonEvent);
				break;
			case "StoredShips":
				event = new StoredShipsEvent(timestamp, jsonEvent);
				break;
			case "TechnologyBroker":
				event = new TechnologyBrokerEvent(timestamp, jsonEvent);
				break;
			case "CargoTransfer":
				event = new CargoTransferEvent(timestamp, jsonEvent);
				break;
			case "CarrierBankTransfer":
				event = new CarrierBankTransferEvent(timestamp, jsonEvent);
				break;
			case "CarrierCrewServices":
				event = new CarrierCrewServicesEvent(timestamp, jsonEvent);
				break;
			case "CarrierDepositFuel":
				event = new CarrierDepositFuelEvent(timestamp, jsonEvent);
				break;
			case "CarrierFinance":
				event = new CarrierFinanceEvent(timestamp, jsonEvent);
				break;
			default:
				GameFilesUtils.sendUnprocessedEvent(eventName, jsonEvent);
				break;
		}

		return event;
	}

	public static class Builder {
		private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();
		private StatusListener statusListener;

		public <T extends Event> Builder addEventListener(Class<T> eventClass, T.Listener listener) {
			this.listeners.put(eventClass, listener);

			return this;
		}

		public Builder setStatusListener(StatusListener statusListener) {
			this.statusListener = statusListener;

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
			eliteDangerousAPI.statusListener = this.statusListener;

			return eliteDangerousAPI;
		}
	}
}
