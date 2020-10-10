package com.github.ChristopheCVB.EliteDangerous.events;

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

/**
 * The Eventlistener to extend from to execute code when a certain event with a registered eventlistener has been found.
 * <p>
 * <pre>{@code
 * public class FSDJumpListener extends Eventlistener {
 *
 *    @Override
 *    public void onFSDJumpEvent(FSDJumpEvent event) {
 * 		// Code to execute when an FSDJump event is detected
 *    }
 *
 * }</pre>
 *
 * @author XenoPyax
 */
public abstract class EventListener {

	//Startup Events
	public void onCargoEvent(CargoEvent event) {
	}

	public void onClearSavedGameEvent(ClearSavedGameEvent event) {
	}

	public void onCommanderEvent(CommanderEvent event) {
	}

	public void onLoadoutEvent(LoadoutEvent event) {
	}

	public void onMaterialsEvent(MaterialsEvent event) {
	}

	public void onMissionEvent(MissionsEvent event) {
	}

	public void onNewCommanderEvent(NewCommanderEvent event) {
	}

	public void onLoadGameEvent(LoadGameEvent event) {
	}

	public void onPassengers(PassengersEvent event) {
	}

	public void onPowerPlayEvent(PowerplayEvent event) {
	}

	public void onProgressEvent(ProgressEvent event) {
	}

	public void onRankEvent(RankEvent event) {
	}

	public void onReputationEvent(ReputationEvent event) {
	}

	public void onStatisticsEvent(StatisticsEvent event) {
	}

	//Travel Events
	public void onApproachBodyEvent(ApproachBodyEvent event) {
	}

	public void onDockedEvent(DockedEvent event) {
	}

	public void onDockingDeniedEvent(DockingDeniedEvent event) {
	}

	public void onDockingGrantedEvent(DockingGrantedEvent event) {
	}

	public void onDockingCancelledEvent(DockingCancelledEvent event) {
	}

	public void onDockingRequestedEvent(DockingRequestedEvent event) {
	}

	public void onFSDJumpEvent(FSDJumpEvent event) {
	}

	public void onFSDTargetEvent(FSDTargetEvent event) {
	}

	public void onLeaveBodyEvent(LeaveBodyEvent event) {
	}

	public void onLiftoffEvent(LiftoffEvent event) {
	}

	public void onLocationEvent(LocationEvent event) {
	}

	public void onStartJumpEvent(StartJumpEvent event) {
	}

	public void onSupercruiseEntryEvent(SupercruiseEntryEvent event) {
	}

	public void onSupercruiseExitEvent(SupercruiseExitEvent event) {
	}

	public void onTouchdownEvent(TouchdownEvent event) {
	}

	public void onUndockedEvent(UndockedEvent event) {
	}

	//Combat Events
	public void onBountyEvent(BountyEvent event) {
	}

	public void onEscapeInterdictionEvent(EscapeInterdictionEvent event) {
	}

	public void onFighterDestroyedEvent(FighterDestroyedEvent event) {
	}

	public void onCapShipBondEvent(CapShipBondEvent event) {
	}

	public void onDiedByWingEvent(DiedByWingEvent event) {
	}

	public void onDiedEvent(DiedEvent event) {
	}

	public void onFactionKillBondEvent(FactionKillBondEvent event) {
	}

	public void onHeatDamageEvent(HeatDamageEvent event) {
	}

	public void onHeatWarningEvent(HeatWarningEvent heatWarningEvent) {
	}

	public void onPassengerEvent(PassengersEvent event) {
	}

	public void onHullDamageEvent(HullDamageEvent event) {
	}

	public void onInterdictedEvent(InterdictedEvent event) {
	}

	public void onInterdictionEvent(InterdictionEvent event) {
	}

	public void onPvPKillEvent(PvPKillEvent event) {
	}

	public void onShieldStateEvent(ShieldStateEvent event) {
	}

	public void onShipTargetedEvent(ShipTargetedEvent event) {
	}

	public void onSRVDestroyedEvent(SRVDestroyedEvent event) {
	}

	public void onUnderAttackEvent(UnderAttackEvent event) {
	}

	//Exploration
	public void onCodexEntryEvent(CodexEntryEvent event) {
	}

	public void onDiscoveryScanEvent(DiscoveryScanEvent event) {
	}

	public void onScanEvent(ScanEvent event) {
	}

	public void onFSSAllBodiesFoundEvent(FSSAllBodiesFoundEvent event) {
	}

	public void onFSSDiscoveryScanEvent(FSSDiscoveryScanEvent event) {
	}

	public void onFSSSignalDiscoveredEvent(FSSSignalDiscoveredEvent event) {
	}

	public void onMaterialCollectedEvent(MaterialCollectedEvent event) {
	}

	public void onMaterialDiscardedEvent(MaterialDiscardedEvent event) {
	}

	public void onMaterialDiscoveredEvent(MaterialDiscoveredEvent event) {
	}

	public void onMultiSellExplorationDataEvent(MultiSellExplorationDataEvent event) {
	}

	public void onNavBeaconScanEvent(NavBeaconScanEvent event) {
	}

	public void onBuyExplorationDataEvent(BuyExplorationDataEvent event) {
	}

	public void onSAAScanCompleteEvent(SAAScanCompleteEvent event) {
	}

	public void onSellExplorationDataEvent(SellExplorationDataEvent event) {
	}

	public void onScreenshotEvent(ScreenshotEvent event) {
	}

	//Trade
	public void onAsteroidCrackedEvet(AsteroidCrackedEvent event) {
	}

	public void onBuyTradeDataEvent(BuyTradeDataEvent event) {
	}

	public void onCollectCargoEvent(CollectCargoEvent event) {
	}

	public void onEjectCargoEvent(EjectCargoEvent event) {
	}

	public void onMarketBuyEvent(MarketBuyEvent event) {
	}

	public void onMarketSellEvent(MarketSellEvent event) {
	}

	public void onMiningRefinedEvent(MiningRefinedEvent event) {
	}

	//Station Services
	public void onBuyAmmoEvent(BuyAmmoEvent event) {
	}

	public void onBuyDronesEvent(BuyDronesEvent event) {
	}

	public void onCargoDepotEvent(CargoDepotEvent event) {
	}

	public void onCommunityGoalEvent(CommunityGoalEvent event) {
	}

	public void onCommunityGoalDiscardEvent(CommunityGoalDiscardEvent event) {
	}

	public void onCommunityGoalJoinEvent(CommunityGoalJoinEvent event) {
	}

	public void onCommunityGoalRewardEvent(CommunityGoalRewardEvent event) {
	}

	public void onCrewAssignEvent(CrewAssignEvent event) {
	}

	public void onCrewFireEvent(CrewFireEvent event) {
	}

	public void onCrewHireEvent(CrewHireEvent event) {
	}

	public void onEngineerContributionEvent(EngineerContributionEvent event) {
	}

	public void onEngineerCraftEvent(EngineerCraftEvent event) {
	}

	public void onEngineerProgressEvent(EngineerProgressEvent event) {
	}

	public void onFetchRemoteModuleEvent(FetchRemoteModuleEvent event) {
	}

	public void onMarketEvent(MarketEvent event) {
	}

	public void onMassModuleStore(MassModuleStoreEvent event) {
	}

	public void onMaterialTrade(MaterialTradeEvent event) {
	}

	public void onMissionAbandoned(MissionAbandonedEvent event) {
	}

	public void onMissionAccepted(MissionAcceptedEvent event) {
	}

	public void onMissionCompleted(MissionCompletedEvent event) {
	}

	public void onMissionFailed(MissionFailedEvent event) {
	}

	public void onMissionRedirected(MissionRedirectedEvent event) {
	}

	public void onModuleBuy(ModuleBuyEvent event) {
	}

	public void onModuleRetrieve(ModuleRetrieveEvent event) {
	}

	public void onModuleSell(ModuleSellEvent event) {
	}

	public void onModuleSellRemote(ModuleSellRemoteEvent event) {
	}

	public void onModuleStore(ModuleStoreEvent event) {
	}

	public void onModuleSwap(ModuleSwapEvent event) {
	}

	public void onOutfitting(OutfittingEvent event) {
	}

	public void onPayBounties(PayBountiesEvent event) {
	}

	public void onPayFines(PayFinesEvent event) {
	}

	public void onRedeemVoucher(RedeemVoucherEvent event) {
	}

	public void onRefuelAll(RefuelAllEvent event) {
	}

	public void onRefuelPartial(RefuelPartialEvent event) {
	}

	public void onRepair(RepairEvent event) {
	}

	public void onRepairAll(RepairAllEvent event) {
	}

	public void onRestockVehicle(RestockVehicleEvent event) {
	}

	public void onScientificResearch(ScientificResearchEvent event) {
	}

	public void onSearchAndRescue(SearchAndRescueEvent event) {
	}

	public void onSellDrones(SellDronesEvent event) {
	}

	public void onSellShipOnRebuy(SellShipOnRebuyEvent event) {
	}

	public void onSetUserShipName(SetUserShipNameEvent event) {
	}

	public void onShipyard(ShipyardEvent event) {
	}

	public void onShipyardBuy(ShipyardBuyEvent event) {
	}

	public void onShipyardNew(ShipyardNewEvent event) {
	}

	public void onShipyardSell(ShipyardSellEvent event) {
	}

	public void onShipyardTransfer(ShipyardTransferEvent event) {
	}

	public void onShipyardSwap(ShipyardSwapEvent event) {
	}

	public void onStoredModules(StoredModulesEvent event) {
	}

	public void onStoredShips(StoredShipsEvent event) {
	}

	public void onTechnologyBrokerEvent(TechnologyBrokerEvent event) {
	}

	// TODO: Needs sorting
	public void onApproachSettlementEvent(ApproachSettlementEvent event) {
	}

	public void onCargoTransferEvent(CargoTransferEvent event) {
	}

	public void onCarrierBankTransferEvent(CarrierBankTransferEvent event) {
	}

	public void onCarrierCrewServicesEvent(CarrierCrewServicesEvent event) {
	}

	public void onCarrierDepositFuelEvent(CarrierDepositFuelEvent event) {
	}

	public void onCarrierFinanceEvent(CarrierFinanceEvent event) {
	}
}
