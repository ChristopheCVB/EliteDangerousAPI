package com.christophecvb.elitedangerous;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.events.Event.Listener;
import com.christophecvb.elitedangerous.events.StatusEvent;
import com.christophecvb.elitedangerous.events.backpack.BackpackChangeEvent;
import com.christophecvb.elitedangerous.events.backpack.BackpackEvent;
import com.christophecvb.elitedangerous.events.backpack.CollectItemsEvent;
import com.christophecvb.elitedangerous.events.backpack.DropItemsEvent;
import com.christophecvb.elitedangerous.events.backpack.TradeMicroResourcesEvent;
import com.christophecvb.elitedangerous.events.backpack.TransferMicroResourcesEvent;
import com.christophecvb.elitedangerous.events.backpack.UseConsumableEvent;
import com.christophecvb.elitedangerous.events.book.BookDropshipEvent;
import com.christophecvb.elitedangerous.events.book.BookTaxiEvent;
import com.christophecvb.elitedangerous.events.book.CancelDropshipEvent;
import com.christophecvb.elitedangerous.events.book.CancelTaxiEvent;
import com.christophecvb.elitedangerous.events.buysell.BuyMicroResourcesEvent;
import com.christophecvb.elitedangerous.events.buysell.BuySuitEvent;
import com.christophecvb.elitedangerous.events.buysell.BuyWeaponEvent;
import com.christophecvb.elitedangerous.events.buysell.SellMicroResourcesEvent;
import com.christophecvb.elitedangerous.events.buysell.SellOrganicDataEvent;
import com.christophecvb.elitedangerous.events.buysell.SellSuitEvent;
import com.christophecvb.elitedangerous.events.buysell.SellWeaponEvent;
import com.christophecvb.elitedangerous.events.combat.BountyEvent;
import com.christophecvb.elitedangerous.events.combat.CapShipBondEvent;
import com.christophecvb.elitedangerous.events.combat.DiedEvent;
import com.christophecvb.elitedangerous.events.combat.EscapeInterdictionEvent;
import com.christophecvb.elitedangerous.events.combat.FactionKillBondEvent;
import com.christophecvb.elitedangerous.events.combat.FighterDestroyedEvent;
import com.christophecvb.elitedangerous.events.combat.HeatDamageEvent;
import com.christophecvb.elitedangerous.events.combat.HeatWarningEvent;
import com.christophecvb.elitedangerous.events.combat.HullDamageEvent;
import com.christophecvb.elitedangerous.events.combat.InterdictedEvent;
import com.christophecvb.elitedangerous.events.combat.InterdictionEvent;
import com.christophecvb.elitedangerous.events.combat.PvPKillEvent;
import com.christophecvb.elitedangerous.events.combat.SRVDestroyedEvent;
import com.christophecvb.elitedangerous.events.combat.ShieldStateEvent;
import com.christophecvb.elitedangerous.events.combat.ShipTargetedEvent;
import com.christophecvb.elitedangerous.events.combat.UnderAttackEvent;
import com.christophecvb.elitedangerous.events.exploration.BuyExplorationDataEvent;
import com.christophecvb.elitedangerous.events.exploration.CodexEntryEvent;
import com.christophecvb.elitedangerous.events.exploration.DiscoveryScanEvent;
import com.christophecvb.elitedangerous.events.exploration.FSSAllBodiesFoundEvent;
import com.christophecvb.elitedangerous.events.exploration.FSSDiscoveryScanEvent;
import com.christophecvb.elitedangerous.events.exploration.FSSSignalDiscoveredEvent;
import com.christophecvb.elitedangerous.events.exploration.MaterialCollectedEvent;
import com.christophecvb.elitedangerous.events.exploration.MaterialDiscardedEvent;
import com.christophecvb.elitedangerous.events.exploration.MaterialDiscoveredEvent;
import com.christophecvb.elitedangerous.events.exploration.MultiSellExplorationDataEvent;
import com.christophecvb.elitedangerous.events.exploration.NavBeaconScanEvent;
import com.christophecvb.elitedangerous.events.exploration.NavRouteEvent;
import com.christophecvb.elitedangerous.events.exploration.SAAScanCompleteEvent;
import com.christophecvb.elitedangerous.events.exploration.SAASignalsFoundEvent;
import com.christophecvb.elitedangerous.events.exploration.ScanEvent;
import com.christophecvb.elitedangerous.events.exploration.ScreenshotEvent;
import com.christophecvb.elitedangerous.events.exploration.SellExplorationDataEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierBankTransferEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierBuyEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierCancelDecommissionEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierCrewServicesEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierDecommissionEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierDepositFuelEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierDockingPermissionEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierFinanceEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierJumpCancelledEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierJumpEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierJumpRequestEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierModulePackEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierNameChangedEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierShipPackEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierStatsEvent;
import com.christophecvb.elitedangerous.events.fleetcarriers.CarrierTradeOrderEvent;
import com.christophecvb.elitedangerous.events.onfoot.DisembarkEvent;
import com.christophecvb.elitedangerous.events.onfoot.DropShipDeployEvent;
import com.christophecvb.elitedangerous.events.onfoot.EmbarkEvent;
import com.christophecvb.elitedangerous.events.onfoot.ScanOrganicEvent;
import com.christophecvb.elitedangerous.events.other.AfmuRepairsEvent;
import com.christophecvb.elitedangerous.events.other.ApproachSettlementEvent;
import com.christophecvb.elitedangerous.events.other.CargoTransferEvent;
import com.christophecvb.elitedangerous.events.other.ChangeCrewRoleEvent;
import com.christophecvb.elitedangerous.events.other.CockpitBreachedEvent;
import com.christophecvb.elitedangerous.events.other.CommitCrimeEvent;
import com.christophecvb.elitedangerous.events.other.ContinuedEvent;
import com.christophecvb.elitedangerous.events.other.CrewLaunchFighterEvent;
import com.christophecvb.elitedangerous.events.other.CrewMemberJoinsEvent;
import com.christophecvb.elitedangerous.events.other.CrewMemberQuitsEvent;
import com.christophecvb.elitedangerous.events.other.CrewMemberRoleChangeEvent;
import com.christophecvb.elitedangerous.events.other.CrimeVictimEvent;
import com.christophecvb.elitedangerous.events.other.DataScannedEvent;
import com.christophecvb.elitedangerous.events.other.DatalinkScanEvent;
import com.christophecvb.elitedangerous.events.other.DatalinkVoucherEvent;
import com.christophecvb.elitedangerous.events.other.DockFighterEvent;
import com.christophecvb.elitedangerous.events.other.DockSRVEvent;
import com.christophecvb.elitedangerous.events.other.EndCrewSessionEvent;
import com.christophecvb.elitedangerous.events.other.FighterRebuiltEvent;
import com.christophecvb.elitedangerous.events.other.FriendsEvent;
import com.christophecvb.elitedangerous.events.other.FuelScoopEvent;
import com.christophecvb.elitedangerous.events.other.JetConeBoostEvent;
import com.christophecvb.elitedangerous.events.other.JetConeDamageEvent;
import com.christophecvb.elitedangerous.events.other.JoinACrewEvent;
import com.christophecvb.elitedangerous.events.other.KickCrewMemberEvent;
import com.christophecvb.elitedangerous.events.other.LaunchDroneEvent;
import com.christophecvb.elitedangerous.events.other.LaunchFighterEvent;
import com.christophecvb.elitedangerous.events.other.LaunchSRVEvent;
import com.christophecvb.elitedangerous.events.other.ModuleInfoEvent;
import com.christophecvb.elitedangerous.events.other.MusicEvent;
import com.christophecvb.elitedangerous.events.other.NpcCrewPaidWageEvent;
import com.christophecvb.elitedangerous.events.other.NpcCrewRankEvent;
import com.christophecvb.elitedangerous.events.other.PromotionEvent;
import com.christophecvb.elitedangerous.events.other.ProspectedAsteroidEvent;
import com.christophecvb.elitedangerous.events.other.QuitACrewEvent;
import com.christophecvb.elitedangerous.events.other.RebootRepairEvent;
import com.christophecvb.elitedangerous.events.other.ReceiveTextEvent;
import com.christophecvb.elitedangerous.events.other.RepairDoneEvent;
import com.christophecvb.elitedangerous.events.other.ResurrectEvent;
import com.christophecvb.elitedangerous.events.other.ScannedEvent;
import com.christophecvb.elitedangerous.events.other.SelfDestructEvent;
import com.christophecvb.elitedangerous.events.other.SendTextEvent;
import com.christophecvb.elitedangerous.events.other.ShipLockerMaterialsEvent;
import com.christophecvb.elitedangerous.events.other.ShutdownEvent;
import com.christophecvb.elitedangerous.events.other.SynthesisEvent;
import com.christophecvb.elitedangerous.events.other.SystemsShutdownEvent;
import com.christophecvb.elitedangerous.events.other.USSDropEvent;
import com.christophecvb.elitedangerous.events.other.VehicleSwitchEvent;
import com.christophecvb.elitedangerous.events.other.WingAddEvent;
import com.christophecvb.elitedangerous.events.other.WingInviteEvent;
import com.christophecvb.elitedangerous.events.other.WingJoinEvent;
import com.christophecvb.elitedangerous.events.other.WingLeaveEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayCollectEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayDefectEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayDeliverEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayFastTrackEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayJoinEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayLeaveEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplaySalaryEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayVoteEvent;
import com.christophecvb.elitedangerous.events.powerplay.PowerplayVoucherEvent;
import com.christophecvb.elitedangerous.events.squadron.AppliedToSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.DisbandedSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.InvitedToSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.JoinedSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.KickedFromSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.LeftSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.SharedBookmarkToSquadronEvent;
import com.christophecvb.elitedangerous.events.squadron.SquadronCreatedEvent;
import com.christophecvb.elitedangerous.events.squadron.SquadronDemotionEvent;
import com.christophecvb.elitedangerous.events.squadron.SquadronPromotionEvent;
import com.christophecvb.elitedangerous.events.squadron.SquadronStartupEvent;
import com.christophecvb.elitedangerous.events.squadron.WonATrophyForSquadronEvent;
import com.christophecvb.elitedangerous.events.startup.CargoEvent;
import com.christophecvb.elitedangerous.events.startup.ClearSavedGameEvent;
import com.christophecvb.elitedangerous.events.startup.CommanderEvent;
import com.christophecvb.elitedangerous.events.startup.LoadGameEvent;
import com.christophecvb.elitedangerous.events.startup.LoadoutEvent;
import com.christophecvb.elitedangerous.events.startup.MaterialsEvent;
import com.christophecvb.elitedangerous.events.startup.MissionsEvent;
import com.christophecvb.elitedangerous.events.startup.NewCommanderEvent;
import com.christophecvb.elitedangerous.events.startup.PassengersEvent;
import com.christophecvb.elitedangerous.events.startup.PowerplayEvent;
import com.christophecvb.elitedangerous.events.startup.ProgressEvent;
import com.christophecvb.elitedangerous.events.startup.RankEvent;
import com.christophecvb.elitedangerous.events.startup.ReputationEvent;
import com.christophecvb.elitedangerous.events.startup.StatisticsEvent;
import com.christophecvb.elitedangerous.events.stationservices.BuyAmmoEvent;
import com.christophecvb.elitedangerous.events.stationservices.BuyDronesEvent;
import com.christophecvb.elitedangerous.events.stationservices.CargoDepotEvent;
import com.christophecvb.elitedangerous.events.stationservices.CommunityGoalDiscardEvent;
import com.christophecvb.elitedangerous.events.stationservices.CommunityGoalEvent;
import com.christophecvb.elitedangerous.events.stationservices.CommunityGoalJoinEvent;
import com.christophecvb.elitedangerous.events.stationservices.CommunityGoalRewardEvent;
import com.christophecvb.elitedangerous.events.stationservices.CrewAssignEvent;
import com.christophecvb.elitedangerous.events.stationservices.CrewFireEvent;
import com.christophecvb.elitedangerous.events.stationservices.CrewHireEvent;
import com.christophecvb.elitedangerous.events.stationservices.EngineerContributionEvent;
import com.christophecvb.elitedangerous.events.stationservices.EngineerCraftEvent;
import com.christophecvb.elitedangerous.events.stationservices.EngineerProgressEvent;
import com.christophecvb.elitedangerous.events.stationservices.FetchRemoteModuleEvent;
import com.christophecvb.elitedangerous.events.stationservices.MarketEvent;
import com.christophecvb.elitedangerous.events.stationservices.MassModuleStoreEvent;
import com.christophecvb.elitedangerous.events.stationservices.MaterialTradeEvent;
import com.christophecvb.elitedangerous.events.stationservices.MissionAbandonedEvent;
import com.christophecvb.elitedangerous.events.stationservices.MissionAcceptedEvent;
import com.christophecvb.elitedangerous.events.stationservices.MissionCompletedEvent;
import com.christophecvb.elitedangerous.events.stationservices.MissionFailedEvent;
import com.christophecvb.elitedangerous.events.stationservices.MissionRedirectedEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleBuyEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleRetrieveEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleSellEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleSellRemoteEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleStoreEvent;
import com.christophecvb.elitedangerous.events.stationservices.ModuleSwapEvent;
import com.christophecvb.elitedangerous.events.stationservices.OutfittingEvent;
import com.christophecvb.elitedangerous.events.stationservices.PayBountiesEvent;
import com.christophecvb.elitedangerous.events.stationservices.PayFinesEvent;
import com.christophecvb.elitedangerous.events.stationservices.RedeemVoucherEvent;
import com.christophecvb.elitedangerous.events.stationservices.RefuelAllEvent;
import com.christophecvb.elitedangerous.events.stationservices.RefuelPartialEvent;
import com.christophecvb.elitedangerous.events.stationservices.RepairAllEvent;
import com.christophecvb.elitedangerous.events.stationservices.RepairEvent;
import com.christophecvb.elitedangerous.events.stationservices.ReservoirReplenishedEvent;
import com.christophecvb.elitedangerous.events.stationservices.RestockVehicleEvent;
import com.christophecvb.elitedangerous.events.stationservices.ScientificResearchEvent;
import com.christophecvb.elitedangerous.events.stationservices.SearchAndRescueEvent;
import com.christophecvb.elitedangerous.events.stationservices.SellDronesEvent;
import com.christophecvb.elitedangerous.events.stationservices.SellShipOnRebuyEvent;
import com.christophecvb.elitedangerous.events.stationservices.SetUserShipNameEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardBuyEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardNewEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardSellEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardSwapEvent;
import com.christophecvb.elitedangerous.events.stationservices.ShipyardTransferEvent;
import com.christophecvb.elitedangerous.events.stationservices.StoredModulesEvent;
import com.christophecvb.elitedangerous.events.stationservices.StoredShipsEvent;
import com.christophecvb.elitedangerous.events.stationservices.TechnologyBrokerEvent;
import com.christophecvb.elitedangerous.events.suit.CreateSuitLoadoutEvent;
import com.christophecvb.elitedangerous.events.suit.DeleteSuitLoadoutEvent;
import com.christophecvb.elitedangerous.events.suit.LoadoutEquipModuleEvent;
import com.christophecvb.elitedangerous.events.suit.LoadoutRemoveModuleEvent;
import com.christophecvb.elitedangerous.events.suit.RenameSuitLoadoutEvent;
import com.christophecvb.elitedangerous.events.suit.SwitchSuitLoadoutEvent;
import com.christophecvb.elitedangerous.events.suit.UpgradeSuitEvent;
import com.christophecvb.elitedangerous.events.suit.UpgradeWeaponEvent;
import com.christophecvb.elitedangerous.events.trade.AsteroidCrackedEvent;
import com.christophecvb.elitedangerous.events.trade.BuyTradeDataEvent;
import com.christophecvb.elitedangerous.events.trade.CollectCargoEvent;
import com.christophecvb.elitedangerous.events.trade.EjectCargoEvent;
import com.christophecvb.elitedangerous.events.trade.MarketBuyEvent;
import com.christophecvb.elitedangerous.events.trade.MarketSellEvent;
import com.christophecvb.elitedangerous.events.trade.MiningRefinedEvent;
import com.christophecvb.elitedangerous.events.travel.ApproachBodyEvent;
import com.christophecvb.elitedangerous.events.travel.DockedEvent;
import com.christophecvb.elitedangerous.events.travel.DockingCancelledEvent;
import com.christophecvb.elitedangerous.events.travel.DockingDeniedEvent;
import com.christophecvb.elitedangerous.events.travel.DockingGrantedEvent;
import com.christophecvb.elitedangerous.events.travel.DockingRequestedEvent;
import com.christophecvb.elitedangerous.events.travel.DockingTimeoutEvent;
import com.christophecvb.elitedangerous.events.travel.FSDJumpEvent;
import com.christophecvb.elitedangerous.events.travel.FSDTargetEvent;
import com.christophecvb.elitedangerous.events.travel.LeaveBodyEvent;
import com.christophecvb.elitedangerous.events.travel.LiftoffEvent;
import com.christophecvb.elitedangerous.events.travel.LocationEvent;
import com.christophecvb.elitedangerous.events.travel.RouteEvent;
import com.christophecvb.elitedangerous.events.travel.StartJumpEvent;
import com.christophecvb.elitedangerous.events.travel.SupercruiseEntryEvent;
import com.christophecvb.elitedangerous.events.travel.SupercruiseExitEvent;
import com.christophecvb.elitedangerous.events.travel.TouchdownEvent;
import com.christophecvb.elitedangerous.events.travel.UndockedEvent;
import com.christophecvb.elitedangerous.models.scan.Parent;
import com.christophecvb.elitedangerous.utils.GameFiles;
import com.christophecvb.elitedangerous.utils.deserializer.BountyEventDeserializer;
import com.christophecvb.elitedangerous.utils.deserializer.DiedEventDeserializer;
import com.christophecvb.elitedangerous.utils.deserializer.EventDeserializer;
import com.christophecvb.elitedangerous.utils.deserializer.ParentDeserializer;
import com.christophecvb.elitedangerous.utils.deserializer.ScanEventDeserializer;
import com.christophecvb.elitedangerous.utils.deserializer.ShipTargetedEventDeserializer;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
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
    eventDeserializer.registerEventType(ShipTargetedEvent.class);
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
    eventDeserializer.registerEventType(SAASignalsFoundEvent.class);

    DiedEventDeserializer diedEventDeserializer = new DiedEventDeserializer();
    ParentDeserializer parentDeserializer = new ParentDeserializer();
    BountyEventDeserializer bountyEventDeserializer = new BountyEventDeserializer();
    ScanEventDeserializer scanEventDeserializer = new ScanEventDeserializer();
    ShipTargetedEventDeserializer shipTargetedEventDeserializer = new ShipTargetedEventDeserializer();

    EliteDangerousAPI.GSON = new GsonBuilder()
        .setFieldNamingStrategy(f -> FieldNamingPolicy.UPPER_CAMEL_CASE.translateName(f)
            .replaceFirst("Localised$", "_Localised"))
        .registerTypeAdapter(Event.class, eventDeserializer)
        .registerTypeAdapter(DiedEvent.class, diedEventDeserializer)
        .registerTypeAdapter(Parent.class, parentDeserializer)
        .registerTypeAdapter(BountyEvent.class, bountyEventDeserializer)
        .registerTypeAdapter(ScanEvent.class, scanEventDeserializer)
        .registerTypeAdapter(ShipTargetedEvent.class, shipTargetedEventDeserializer)
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
        .create();
  }

  private boolean active = false;
  private File journalFile;
  private RandomAccessFile randomAccessFile;
  private Thread journalReaderThread;
  private ScheduledExecutorService scheduledExecutorService;
  private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();
  private final Date triggerEventsSince;

  private Thread createJournalReaderThread() {
    return new Thread(() -> {
      while (this.active) {
        File latestJournalFile = GameFiles.getExistingInstance().getLatestJournalFile();
        if (latestJournalFile == null) {
          File gameFilesDirectory = GameFiles.getExistingInstance().getDirectory();
          System.out.println("Game Files Directory exists: " + gameFilesDirectory.exists());
          System.out.println(
              "Journal File does not exists in: " + gameFilesDirectory.getAbsolutePath());
          try {
            Thread.sleep(4000);
          } catch (InterruptedException ignored) {
          }
        } else {
          if (!latestJournalFile.equals(this.journalFile)) {
            this.journalFile = latestJournalFile;
            this.randomAccessFile = null;
          }

          if (this.randomAccessFile == null) {
            try {
              this.randomAccessFile = new RandomAccessFile(this.journalFile, "r");
            } catch (FileNotFoundException ignored) {
            }
          }

          try {
            if (this.randomAccessFile != null) {
              String rawEvent = this.randomAccessFile.readLine();
              if (rawEvent != null) {
                JsonObject jsonEvent = JsonParser.parseString(
                    new String(rawEvent.getBytes(StandardCharsets.UTF_8))).getAsJsonObject();

                Event event = this.parseEvent(jsonEvent);
                if (event != null) {
                  this.triggerEventIfNeededSafely(event);
                }
              } else {
                // Game is creating another file, give it some time
                try {
                  Thread.sleep(500);
                } catch (InterruptedException ignored) {
                }
              }
            } else {
              System.out.println("RandomAccessFile File could not be created");
            }
          } catch (IOException | JsonSyntaxException e) {
            e.printStackTrace();
          }
        }
      }
    });
  }

  protected <T extends Event> void triggerEventIfNeededSafely(T event) {
    if (event.timestamp.after(this.triggerEventsSince)) {
      Class<? extends Event> eventClass = event.getClass();
      if (this.listeners.containsKey(eventClass)) {
        try {
          this.listeners.get(event.getClass()).onTriggered(event);
        } catch (Exception ignored) {
        }
      } else {
        Class<?> eventSuperClass = eventClass.getSuperclass();
        while (!eventSuperClass.equals(Event.class)) {
          if (this.listeners.containsKey(eventSuperClass)) {
            try {
              this.listeners.get(eventSuperClass).onTriggered(event);
            } catch (Exception ignored) {
            }
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

  private EliteDangerousAPI(File gameFilesDirectory, Date triggerEventsSince,
      Map<? extends Class<? extends Event>, ? extends Listener> listeners) {
    GameFiles.getInstance(gameFilesDirectory);
    this.listeners.putAll(listeners);
    this.triggerEventsSince = triggerEventsSince;
  }

  public boolean isActive() {
    return this.active && this.journalReaderThread != null && this.journalReaderThread.isAlive();
  }

  public void stop() {
    this.active = false;
    if (this.journalReaderThread != null && !this.journalReaderThread.isInterrupted()) {
      this.journalReaderThread.interrupt();
      this.journalReaderThread = null;
    }
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
    this.scheduledExecutorService.scheduleWithFixedDelay(this::triggerStatusEventIfNeeded, 0, 500,
        TimeUnit.MILLISECONDS);
  }

  protected Event parseEvent(JsonObject jsonEvent) {
    Event event = null;
    try {
      event = EliteDangerousAPI.GSON.fromJson(jsonEvent, Event.class);
    } catch (JsonSyntaxException ignored) {
    }

    if (event == null) {
      GameFiles.onUnprocessedEvent(jsonEvent);
    }

    return event;
  }

  public Date getTriggerEventsSince() {
    return this.triggerEventsSince;
  }

  public static class Builder {

    private File gameFilesDirectory = null;
    private Date triggerEventsSince = new Date(0);
    private final Map<Class<? extends Event>, Event.Listener> listeners = new HashMap<>();

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
     * Set the Game Files Directory
     *
     * @param gameFilesDirectory File
     * @return Builder builder
     */
    public Builder setGameFilesDirectory(File gameFilesDirectory) {
      this.gameFilesDirectory = gameFilesDirectory;

      return this;
    }

    /**
     * Instantiate the {@link EliteDangerousAPI} class and returns it for further use.
     *
     * @return The populated {@link EliteDangerousAPI} class
     */
    public EliteDangerousAPI build() {
      return new EliteDangerousAPI(
          this.gameFilesDirectory,
          this.triggerEventsSince,
          this.listeners
      );
    }
  }
}
