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
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.exceptions.UnsupportedGameVersion;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class EliteDangerousAPI {
	private final String[] SUPPORTED_VERSIONS = new String[]{"Fleet Carriers Update", "Fleet Carriers Update - Update 1", "Fleet Carriers Update - Patch 5"};

	private boolean active = false;
	private boolean isFirstLine = true;
	private File journalFile;
	private RandomAccessFile randomAccessFile;
	private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();
	private Thread readerThread;

	private Thread createReaderThread() {
		return new Thread(() -> {
			while (this.active) {
				File latestJournalFile = GameFilesUtils.getLatestJournalFile();
				if (!latestJournalFile.equals(this.journalFile)) {
					this.journalFile = latestJournalFile;
					this.randomAccessFile = null;
				}

				if (this.randomAccessFile == null) {
					if (this.journalFile.exists()) {
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
			case "ApproachBody":
				event = new ApproachBodyEvent(timestamp, jsonEvent);
				break;
			case "ApproachSettlement":
				event = new ApproachSettlementEvent(timestamp, jsonEvent);
				break;
			case "Docked":
				event = new DockedEvent(timestamp, jsonEvent);
				break;
			case "DockingDenied":
				event = new DockingDeniedEvent(timestamp, jsonEvent);
				break;
			case "DockingGranted":
				event = new DockingGrantedEvent(timestamp, jsonEvent);
				break;
			case "DockingCancelled":
				event = new DockingCancelledEvent(timestamp, jsonEvent);
				break;
			case "DockingRequested":
				event = new DockingRequestedEvent(timestamp, jsonEvent);
				break;
			case "FSDJump":
				event = new FSDJumpEvent(timestamp, jsonEvent);
				break;
			case "FSDTarget":
				event = new FSDTargetEvent(timestamp, jsonEvent);
				break;
			case "LeaveBody":
				event = new LeaveBodyEvent(timestamp, jsonEvent);
				break;
			case "Liftoff":
				event = new LiftoffEvent(timestamp, jsonEvent);
				break;
			case "Location":
				event = new LocationEvent(timestamp, jsonEvent);
				break;
			case "StartJump":
				event = new StartJumpEvent(timestamp, jsonEvent);
				break;
			case "SupercruiseEntry":
				event = new SupercruiseEntryEvent(timestamp, jsonEvent);
				break;
			case "SupercruiseExit":
				event = new SupercruiseExitEvent(timestamp, jsonEvent);
				break;
			case "Touchdown":
				event = new TouchdownEvent(timestamp, jsonEvent);
				break;
			case "Undocked":
				event = new UndockedEvent(timestamp, jsonEvent);
				break;
			case "Bounty":
				event = new BountyEvent(timestamp, jsonEvent);
				break;
			case "EscapeInterdiction":
				event = new EscapeInterdictionEvent(timestamp, jsonEvent);
				break;
			case "FighterDestroyed":
				event = new FighterDestroyedEvent(timestamp, jsonEvent);
				break;
			case "CapShipBond":
				event = new CapShipBondEvent(timestamp, jsonEvent);
				break;
			case "Died":
				if (!jsonEvent.has("Killers")) {
					event = new DiedEvent(timestamp, jsonEvent);
				}
				else {
					event = new DiedByWingEvent(timestamp, jsonEvent);
				}
				break;
			case "FactionKillBond":
				event = new FactionKillBondEvent(timestamp, jsonEvent);
				break;
			case "HeatDamage":
				event = new HeatDamageEvent(timestamp, jsonEvent);
				break;
			case "HeatWarning":
				event = new HeatWarningEvent(timestamp, jsonEvent);
				break;
			case "HullDamage":
				event = new HullDamageEvent(timestamp, jsonEvent);
				break;
			case "Interdicted":
				event = new InterdictedEvent(timestamp, jsonEvent);
				break;
			case "Interdiction":
				event = new InterdictionEvent(timestamp, jsonEvent);
				break;
			case "PvPKill":
				event = new PvPKillEvent(timestamp, jsonEvent);
				break;
			case "ShieldState":
				event = new ShieldStateEvent(timestamp, jsonEvent);
				break;
			case "ShipTargeted":
				event = new ShipTargetedEvent(timestamp, jsonEvent);
				break;
			case "SRVDestroyed":
				event = new SRVDestroyedEvent(timestamp, jsonEvent);
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
