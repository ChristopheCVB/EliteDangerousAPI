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

		DiedEventDeserializer diedEventDeserializer = new DiedEventDeserializer();

		this.gson = new GsonBuilder()
				.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
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
			case "UnderAttack":
				event = new UnderAttackEvent(timestamp, jsonEvent);
				break;
			case "CodexEntry":
				event = new CodexEntryEvent(timestamp, jsonEvent);
				break;
			case "DiscoveryScan":
				event = new DiscoveryScanEvent(timestamp, jsonEvent);
				break;
			case "Scan":
				event = new ScanEvent(timestamp, jsonEvent);
				break;
			case "FSSAllBodiesFound":
				event = new FSSAllBodiesFoundEvent(timestamp, jsonEvent);
				break;
			case "FSSDiscoveryScan":
				event = new FSSDiscoveryScanEvent(timestamp, jsonEvent);
				break;
			case "FSSSignalDiscovered":
				event = new FSSSignalDiscoveredEvent(timestamp, jsonEvent);
				break;
			case "MaterialCollected":
				event = new MaterialCollectedEvent(timestamp, jsonEvent);
				break;
			case "MaterialDiscarded":
				event = new MaterialDiscardedEvent(timestamp, jsonEvent);
				break;
			case "MaterialDiscovered":
				event = new MaterialDiscoveredEvent(timestamp, jsonEvent);
				break;
			case "MultiSellExplorationData":
				event = new MultiSellExplorationDataEvent(timestamp, jsonEvent);
				break;
			case "NavBeaconScan":
				event = new NavBeaconScanEvent(timestamp, jsonEvent);
				break;
			case "BuyExplorationData":
				event = new BuyExplorationDataEvent(timestamp, jsonEvent);
				break;
			case "SAAScanComplete":
				event = new SAAScanCompleteEvent(timestamp, jsonEvent);
				break;
			case "SellExplorationData":
				event = new SellExplorationDataEvent(timestamp, jsonEvent);
				break;
			case "Screenshot":
				event = new ScreenshotEvent(timestamp, jsonEvent);
				break;
			case "AsteroidCracked":
				event = new AsteroidCrackedEvent(timestamp, jsonEvent);
				break;
			case "BuyTradeData":
				event = new BuyTradeDataEvent(timestamp, jsonEvent);
				break;
			case "CollectCargo":
				event = new CollectCargoEvent(timestamp, jsonEvent);
				break;
			case "EjectCargo":
				event = new EjectCargoEvent(timestamp, jsonEvent);
				break;
			case "MarketBuy":
				event = new MarketBuyEvent(timestamp, jsonEvent);
				break;
			case "MarketSell":
				event = new MarketSellEvent(timestamp, jsonEvent);
				break;
			case "MiningRefined":
				event = new MiningRefinedEvent(timestamp, jsonEvent);
				break;
			case "BuyAmmo":
				event = new BuyAmmoEvent(timestamp, jsonEvent);
				break;
			case "BuyDrones":
				event = new BuyDronesEvent(timestamp, jsonEvent);
				break;
			case "CargoDepot":
				event = new CargoDepotEvent(timestamp, jsonEvent);
				break;
			case "CommunityGoal":
				event = new CommunityGoalEvent(timestamp, jsonEvent);
				break;
			case "CommunityGoalDiscard":
				event = new CommunityGoalDiscardEvent(timestamp, jsonEvent);
				break;
			case "CommunityGoalJoin":
				event = new CommunityGoalJoinEvent(timestamp, jsonEvent);
				break;
			case "CommunityGoalReward":
				event = new CommunityGoalRewardEvent(timestamp, jsonEvent);
				break;
			case "CrewAssign":
				event = new CrewAssignEvent(timestamp, jsonEvent);
				break;
			case "CrewFire":
				event = new CrewFireEvent(timestamp, jsonEvent);
				break;
			case "CrewHire":
				event = new CrewHireEvent(timestamp, jsonEvent);
				break;
			case "EngineerContribution":
				event = new EngineerContributionEvent(timestamp, jsonEvent);
				break;
			case "EngineerCraft":
				event = new EngineerCraftEvent(timestamp, jsonEvent);
				break;
			case "EngineerProgress":
				event = new EngineerProgressEvent(timestamp, jsonEvent);
				break;
			case "FetchRemoteModule":
				event = new FetchRemoteModuleEvent(timestamp, jsonEvent);
				break;
			case "Market":
				event = new MarketEvent(timestamp, jsonEvent);
				break;
			case "MassModuleStore":
				event = new MassModuleStoreEvent(timestamp, jsonEvent);
				break;
			case "MaterialTrade":
				event = new MaterialTradeEvent(timestamp, jsonEvent);
				break;
			case "MissionAbandoned":
				event = new MissionAbandonedEvent(timestamp, jsonEvent);
				break;
			case "MissionAccepted":
				event = new MissionAcceptedEvent(timestamp, jsonEvent);
				break;
			case "MissionCompleted":
				event = new MissionCompletedEvent(timestamp, jsonEvent);
				break;
			case "MissionFailed":
				event = new MissionFailedEvent(timestamp, jsonEvent);
				break;
			case "MissionRedirected":
				event = new MissionRedirectedEvent(timestamp, jsonEvent);
				break;
			case "ModuleBuy":
				event = new ModuleBuyEvent(timestamp, jsonEvent);
				break;
			case "ModuleRetrieve":
				event = new ModuleRetrieveEvent(timestamp, jsonEvent);
				break;
			case "ModuleSell":
				event = new ModuleSellEvent(timestamp, jsonEvent);
				break;
			case "ModuleSellRemote":
				event = new ModuleSellRemote(timestamp, jsonEvent);
				break;
			case "ModuleStore":
				event = new ModuleStoreEvent(timestamp, jsonEvent);
				break;
			case "ModuleSwap":
				event = new ModuleSwapEvent(timestamp, jsonEvent);
				break;
			case "Outfitting":
				event = new OutfittingEvent(timestamp, jsonEvent);
				break;
			case "PayBounties":
				event = new PayBountiesEvent(timestamp, jsonEvent);
				break;
			case "PayFines":
				event = new PayFinesEvent(timestamp, jsonEvent);
				break;
			case "RedeemVoucher":
				event = new RedeemVoucherEvent(timestamp, jsonEvent);
				break;
			case "RefuelAll":
				event = new RefuelAllEvent(timestamp, jsonEvent);
				break;
			case "RefuelPartial":
				event = new RefuelPartialEvent(timestamp, jsonEvent);
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
			case "Music":
				event = new MusicEvent(timestamp, jsonEvent);
				break;
			case "ReceiveText":
				event = new ReceiveTextEvent(timestamp, jsonEvent);
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
