package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class StatisticsEvent extends Event {

  @SerializedName("Bank_Account")
  public BankAccount bankAccount;
  public Combat combat;
  public Crime crime;
  public Smuggling smuggling;
  public Trading trading;
  public Mining mining;
  public Exploration exploration;
  public Passengers passengers;
  @SerializedName("Search_And_Rescue")
  public SearchAndRescue searchAndRescue;
  @SerializedName("TG_ENCOUNTERS")
  public ThargoidEncounters thargoidEncounters;
  public Crafting crafting;
  public Crew crew;
  public Multicrew multicrew;
  @SerializedName("Material_Trader_Stats")
  public MaterialTraderStats materialTraderStats;
  @SerializedName("FLEETCARIER")
  public FleetCarrier fleetCarrier;
  @SerializedName("CQC")
  public CQC cqc;

  public static class BankAccount {

    @SerializedName("Current_Wealth")
    public Long currentWealth;
    @SerializedName("Spent_On_Ships")
    public Long spentOnShips;
    @SerializedName("Spent_On_Outfitting")
    public Long spentOnOutfitting;
    @SerializedName("Spent_On_Repairs")
    public Long spentOnRepairs;
    @SerializedName("Spent_On_Fuel")
    public Long spentOnFuel;
    @SerializedName("Spent_On_Ammo_Consumables")
    public Long spentOnAmmoConsumables;
    @SerializedName("Spent_On_Insurance")
    public Long spentOnInsurance;
    @SerializedName("Insurance_Claims")
    public Integer insuranceClaims;
    @SerializedName("Owned_Ship_Count")
    public Integer ownedShipCount;
  }

  public static class Combat {

    public Long bountyHuntingProfit;
    public Long combatBondsProfit;
    public Long assassinationProfits;
    public Integer bountiesClaimed;
    public Integer combatBonds;
    public Integer assassinations;
    public Integer highestSingleReward;
    public Integer skimmersKilled;
  }

  public static class Crime {

    @SerializedName("Total_Fines")
    public Long totalFines;
    @SerializedName("Total_Bounties")
    public Long totalBounties;
    @SerializedName("Bounties_Received")
    public Integer bountiesReceived;
    public Integer notoriety;
    public Integer fines;
    @SerializedName("Highest_Bounty")
    public Integer highestBounty;
  }

  public static class Smuggling {

    @SerializedName("Black_Markets_Profits")
    public Long blackMarketsProfit;
    @SerializedName("Average_Profit")
    public Long averageProfit;
    @SerializedName("Black_Markets_Traded_With")
    public Integer blackMarketsTradedWith;
    @SerializedName("Resources_Smuggled")
    public Integer resourcesSmuggled;
    @SerializedName("Highest_Single_Transaction")
    public Integer highestSingleTransaction;
  }

  public static class Trading {

    @SerializedName("Market_Profits")
    public Long marketProfits;
    @SerializedName("Average_Profit")
    public Long averageProfit;
    @SerializedName("Markets_Traded_With")
    public Integer marketsTradedWith;
    @SerializedName("Resources_Traded")
    public Integer resourcesTraded;
    @SerializedName("Highest_Single_Transaction")
    public Integer highestSingleTransaction;
  }

  public static class Mining {

    @SerializedName("Mining_Profits")
    public Long miningProfits;
    @SerializedName("Quantity_Mined")
    public Integer quantityMined;
    @SerializedName("Materials_Collected")
    public Integer materialsCollected;
  }

  public static class Exploration {

    @SerializedName("Exploration_Profits")
    public Long explorationProfits;
    @SerializedName("Systems_Visited")
    public Integer systemsVisited;
    @SerializedName("Planets_Scanned_To_Level_2")
    public Integer planetsScannedToLevel2;
    @SerializedName("Planets_Scanned_To_Level_3")
    public Integer planetsScannedToLevel3;
    @SerializedName("Efficient_Scans")
    public Integer efficientScans;
    @SerializedName("Highest_Payout")
    public Integer highestPayout;
    @SerializedName("Total_Hyperspace_Distance")
    public Integer totalHyperspaceDistance;
    @SerializedName("Total_Hyperspace_Jumps")
    public Integer totalHyperspaceJumps;
    @SerializedName("Greatest_Distance_From_Start")
    public Integer greatestDistanceFromStart;
    @SerializedName("Time_Played")
    public Integer timePlayed;
  }

  public static class Passengers {

    @SerializedName("Passengers_Missions_Accepted")
    public Integer passengersMissionsAccepted;
    @SerializedName("Passengers_Missions_Disgruntled")
    public Integer passengersMissionsDisgruntled;
    @SerializedName("Passengers_Missions_Bulk")
    public Integer passengersMissionsBulk;
    @SerializedName("Passengers_Missions_VIP")
    public Integer passengersMissionsVIP;
    @SerializedName("Passengers_Missions_Delivered")
    public Integer passengersMissionsDelivered;
    @SerializedName("Passengers_Missions_Ejected")
    public Integer passengersMissionsEjected;
  }

  public static class SearchAndRescue {

    @SerializedName("SearchRescue_Profit")
    public Long searchRescueProfit;
    @SerializedName("SearchRescue_Traded")
    public Integer searchRescueTraded;
    @SerializedName("SearchRescue_Count")
    public Integer searchRescueCount;
  }

  public static class ThargoidEncounters {

    @SerializedName("TG_ENCOUNTER_TOTAL")
    public Integer tgEncounterTotal;
    @SerializedName("TG_SCOUT_COUNT")
    public Integer tgScoutCount;
    @SerializedName("TG_ENCOUNTER_TOTAL_LAST_SYSTEM")
    public String tgEncounterTotalLastSystem;
    @SerializedName("TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP")
    public String tgEncounterTotalLastTimestamp;
    @SerializedName("TG_ENCOUNTER_TOTAL_LAST_SHIP")
    public String tgEncounterTotalLastShip;
  }

  public static class Crafting {

    @SerializedName("Count_Of_Used_Engineers")
    public Integer engineersUsedCount;
    @SerializedName("Recipes_Generated")
    public Integer recipesGenerated;
    @SerializedName("Recipes_Generated_Rank_1")
    public Integer recipesGeneratedRank1;
    @SerializedName("Recipes_Generated_Rank_2")
    public Integer recipesGeneratedRank2;
    @SerializedName("Recipes_Generated_Rank_3")
    public Integer recipesGeneratedRank3;
    @SerializedName("Recipes_Generated_Rank_4")
    public Integer recipesGeneratedRank4;
    @SerializedName("Recipes_Generated_Rank_5")
    public Integer recipesGeneratedRank5;
  }

  public static class Crew {

    @SerializedName("NpcCrew_TotalWages")
    public Long npcCrewTotalWages;
    @SerializedName("NpcCrew_Hired")
    public Integer npcCrewHired;
    @SerializedName("NpcCrew_Fired")
    public Integer npcCrewFired;
  }

  public static class Multicrew {

    @SerializedName("Multicrew_Time_Total")
    public Integer multicrewTimeTotal;
    @SerializedName("Multicrew_Gunner_Time_Total")
    public Integer multicrewTimeGunnerTotal;
    @SerializedName("Multicrew_Fighter_Time_Total")
    public Integer multicrewTimeFighterTotal;
    @SerializedName("Multicrew_Credits_Total")
    public Integer multicrewCreditsTotal;
    @SerializedName("Multicrew_Fines_Total")
    public Integer multicrewFinesTotal;
  }

  public static class MaterialTraderStats {

    @SerializedName("Trades_Completed")
    public Integer tradesCompleted;
    @SerializedName("Materials_Traded")
    public Integer materialsTraded;
    @SerializedName("Encoded_Materials_Traded")
    public Integer encodedMaterialsTraded;
    @SerializedName("Grade_1_Materials_Traded")
    public Integer grade1MaterialsTraded;
    @SerializedName("Grade_2_Materials_Traded")
    public Integer grade2MaterialsTraded;
    @SerializedName("Grade_3_Materials_Traded")
    public Integer grade3MaterialsTraded;
    @SerializedName("Grade_4_Materials_Traded")
    public Integer grade4MaterialsTraded;
    @SerializedName("Grade_5_Materials_Traded")
    public Integer grade5MaterialsTraded;
  }

  public static class FleetCarrier {

    @SerializedName("FLEETCARRIER_REARM_TOTAL")
    public Long fleetCarrierRearmTotal;
    @SerializedName("FLEETCARRIER_TOTAL_JUMPS")
    public Long fleetCarrierTotalJumps;
    @SerializedName("FLEETCARRIER_EXPORT_TOTAL")
    public Long fleetCarrierExportTotal;
    @SerializedName("FLEETCARRIER_IMPORT_TOTAL")
    public Long fleetCarrierImportTotal;
    @SerializedName("FLEETCARRIER_REFUEL_TOTAL")
    public Long fleetCarrierRefuelTotal;
    @SerializedName("FLEETCARRIER_REFUEL_PROFIT")
    public Long fleetCarrierRefuelProfit;
    @SerializedName("FLEETCARRIER_REPAIRS_TOTAL")
    public Long fleetCarrierRepairsTotal;
    @SerializedName("FLEETCARRIER_SHIPYARD_SOLD")
    public Long fleetCarrierShipyardSold;
    @SerializedName("FLEETCARRIER_OUTFITTING_SOLD")
    public Long fleetCarrierOutfittingSold;
    @SerializedName("FLEETCARRIER_SHIPYARD_PROFIT")
    public Long fleetCarrierShipyardProfit;
    @SerializedName("FLEETCARRIER_VOUCHERS_PROFIT")
    public Long fleetCarrierVouchersProfit;
    @SerializedName("FLEETCARRIER_TRADESPEND_TOTAL")
    public Long fleetCarrierTradeSpendTotal;
    @SerializedName("FLEETCARRIER_OUTFITTING_PROFIT")
    public Long fleetCarrierOutfittingProfit;
    @SerializedName("FLEETCARRIER_STOLENSPEND_TOTAL")
    public Long fleetCarrierStolenSpendTotal;
    @SerializedName("FLEETCARRIER_TRADEPROFIT_TOTAL")
    public Long fleetCarrierTradeProfitTotal;
    @SerializedName("FLEETCARRIER_VOUCHERS_REDEEMED")
    public Long fleetCarrierVouchersRedeemed;
    @SerializedName("FLEETCARRIER_STOLENPROFIT_TOTAL")
    public Long fleetCarrierStolenProfitTotal;
    @SerializedName("FLEETCARRIER_DISTANCE_TRAVELLED")
    public String fleetCarrierDistanceTravelled;
  }

  public static class CQC {

    @SerializedName("CQC_KD")
    public Double cqcKD;
    @SerializedName("CQC_WL")
    public Double cqcWL;
    @SerializedName("CQC_Kills")
    public Long cqcKills;
    @SerializedName("CQC_Time_Played")
    public Long cqcTimePlayed;
    @SerializedName("CQC_Credits_Earned")
    public Long cqcCreditsEarned;
  }

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onStatisticsEventTriggered((StatisticsEvent) event);
    }

    void onStatisticsEventTriggered(StatisticsEvent statisticsEvent);
  }
}
