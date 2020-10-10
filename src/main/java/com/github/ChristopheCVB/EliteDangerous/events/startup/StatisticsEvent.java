package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class StatisticsEvent extends Event {
	// TODO: Refactor StatisticsEvent with subclasses
	@SerializedName("Bank_Account")
	public BankAccount bankAccount;
	public Combat combat;

	private Long currentWealth, spentOnShips, spentOnOutfitting, spentOnRepairs, spentOnFuel, spentOnAmmoConsumables, spentOnInsurance, bountyHuntingProfit, combatBondsProfit, assassinationProfits,
	totalFines, totalBounties, blackMarketsProfit, averageSmugglingProfit, marketProfit, miningProfits, explorationProfits, searchRescueProfit, totalNpcCrewWages, fleetCarrierRearmTotal,
	fleetCarrierExportTotal, fleetCarrierImportTotal, fleetCarrierRefuelTotal, fleetCarrierRefuelProfit, fleetCarrierRepairsTotal, fleetCarrierShipyardSold, fleetCarrierOutfittingSold,
	fleetCarrierShipyardProfit, fleetCarrierVouchersProfit, fleetCarrierTradespendTotal, fleetCarrierOutfittingProfit, fleetCarrierStolenspendTotal, fleetCarrierTradeprofitTotal,
	fleetCarrierVouchersRedeemed, fleetCarrierStolenprofitTotal, cqcKills, cqcTimePlayed, cqcCreditsEarned, fleetCarrierTotalJumps;
	
	private Integer bountiesReceived, insuranceClaims, ownedShipCount, bountiesClaimed, combatBonds, assassinations, highestSingleReward, skimmersKilled, notoriety, fines, highestBounty,
	blackMartketsTradedWith, ressourcesSmuggled, highestSingleSmugglingTransaction, marketsTradedWith, ressourcesTraded, averageTradingProfit, highestSingleTradingTransaction, quantityMined,
	materialsCollected, systemsVisited, planetsScannedToLevel2, planetsScannedToLevel3, efficientScans, highestPayout, totalHyperspaceDistance, totalHyperspaceJumps, greatestDistanceFromStart,
	timePlayed, passengersMissionsAccepted, passengersMissionsDisgruntled, passengersMissionsBulk, passengersMissionsVIP, passengersMissionsDelivered, passengersMissionsEjected,
	searchRescueTraded,	searchRescueCount, totalTGEncounters, tGScoutCount, engineersUsedCount, totalRecipesGenerated, recipesGeneratedRank1, recipesGeneratedRank2, recipesGeneratedRank3,
	recipesGeneratedRank4, recipesGeneratedRank5, hiredNpcCrew, firedNpcCrew, totalMulticrewTime, totalMulticrewTimeGunner, totalMulticrewTimeFighter, totalMulticrewCredits, totalMulticrewFines,
	materialTraderTradesCompledted, materialTraderMaterialsTraded, materialTraderEncodedMaterialsTraded, materialTraderGrade1Traded, materialTraderGrade2Traded, materialTraderGrade3Traded,
	materialTraderGrade4Traded, materialTraderGrade5Traded;
	
	private String lastTGEncounterSystem, lastTGEncounterTime, lastTGEncounterShip, fleetCarrierDistanceTravelled;
	
	private Double cqcKD, cqcWL;

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
	
	public StatisticsEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		JsonObject crime = JsonUtils.pullJsonObject(jsonEvent, "Crime");
		JsonObject smuggling = JsonUtils.pullJsonObject(jsonEvent, "Smuggling");
		JsonObject trading = JsonUtils.pullJsonObject(jsonEvent, "Trading");
		JsonObject mining = JsonUtils.pullJsonObject(jsonEvent, "Mining");
		JsonObject exploration = JsonUtils.pullJsonObject(jsonEvent, "Exploration");
		JsonObject passengers = JsonUtils.pullJsonObject(jsonEvent, "Passengers");
		JsonObject searchAndRescue = JsonUtils.pullJsonObject(jsonEvent, "Search_And_Rescue");
		if (jsonEvent.has("TG_ENCOUNTERS")) {
			JsonObject thargoid = JsonUtils.pullJsonObject(jsonEvent, "TG_ENCOUNTERS");

			// Thargoid
			this.totalTGEncounters = JsonUtils.pullInt(thargoid, "TG_ENCOUNTER_TOTAL");
			this.tGScoutCount = JsonUtils.pullInt(thargoid, "TG_SCOUT_COUNT");
			this.lastTGEncounterSystem = JsonUtils.pullString(thargoid, "TG_ENCOUNTER_TOTAL_LAST_SYSTEM");
			this.lastTGEncounterTime = JsonUtils.pullString(thargoid, "TG_ENCOUNTER_TOTAL_LAST_TIMESTAMP");
			this.lastTGEncounterShip = JsonUtils.pullString(thargoid, "TG_ENCOUNTER_TOTAL_LAST_SHIP");
		}
		if (jsonEvent.has("Crafting")) {
			JsonObject crafting = JsonUtils.pullJsonObject(jsonEvent, "Crafting");

			// Crafting
			this.engineersUsedCount = JsonUtils.pullInt(crafting, "Count_Of_Used_Engineers");
			this.totalRecipesGenerated = JsonUtils.pullInt(crafting, "Recipes_Generated");
			this.recipesGeneratedRank1 = JsonUtils.pullInt(crafting, "Recipes_Generated_Rank_1");
			this.recipesGeneratedRank2 = JsonUtils.pullInt(crafting, "Recipes_Generated_Rank_2");
			this.recipesGeneratedRank3 = JsonUtils.pullInt(crafting, "Recipes_Generated_Rank_3");
			this.recipesGeneratedRank4 = JsonUtils.pullInt(crafting, "Recipes_Generated_Rank_4");
			this.recipesGeneratedRank5 = JsonUtils.pullInt(crafting, "Recipes_Generated_Rank_5");
		}
		if (jsonEvent.has("Crew")) {
			JsonObject crew = JsonUtils.pullJsonObject(jsonEvent, "Crew");

			// Crew
			this.totalNpcCrewWages = JsonUtils.pullLong(crew, "NpcCrew_TotalWages");
			this.hiredNpcCrew = JsonUtils.pullInt(crew, "NpcCrew_Hired");
			this.firedNpcCrew = JsonUtils.pullInt(crew, "NpcCrew_Fired");
		}
		if (jsonEvent.has("Multicrew")) {
			JsonObject multicrew = JsonUtils.pullJsonObject(jsonEvent, "Multicrew");

			// Multicrew
			this.totalMulticrewTime = JsonUtils.pullInt(multicrew, "Multicrew_Time_Total");
			this.totalMulticrewTimeGunner = JsonUtils.pullInt(multicrew, "Multicrew_Gunner_Time_Total");
			this.totalMulticrewTimeFighter = JsonUtils.pullInt(multicrew, "Multicrew_Fighter_Time_Total");
			this.totalMulticrewCredits = JsonUtils.pullInt(multicrew, "Multicrew_Credits_Total");
			this.totalMulticrewFines = JsonUtils.pullInt(multicrew, "Multicrew_Fines_Total");
		}
		if (jsonEvent.has("Material_Trader_Stats")) {
			JsonObject materialTrader = JsonUtils.pullJsonObject(jsonEvent, "Material_Trader_Stats");

			// Material Traders
			this.materialTraderTradesCompledted = JsonUtils.pullInt(materialTrader, "Trades_Completed");
			this.materialTraderMaterialsTraded = JsonUtils.pullInt(materialTrader, "Materials_Traded");
			this.materialTraderEncodedMaterialsTraded = JsonUtils.pullInt(materialTrader, "Encoded_Materials_Traded");
			this.materialTraderGrade1Traded = JsonUtils.pullInt(materialTrader, "Grade_1_Materials_Traded");
			this.materialTraderGrade2Traded = JsonUtils.pullInt(materialTrader, "Grade_2_Materials_Traded");
			this.materialTraderGrade3Traded = JsonUtils.pullInt(materialTrader, "Grade_3_Materials_Traded");
			this.materialTraderGrade4Traded = JsonUtils.pullInt(materialTrader, "Grade_4_Materials_Traded");
			this.materialTraderGrade5Traded = JsonUtils.pullInt(materialTrader, "Grade_5_Materials_Traded");
		}
		if (jsonEvent.has("FLEETCARIER")) {
			JsonObject fleetCarrier = JsonUtils.pullJsonObject(jsonEvent, "FLEETCARRIER");

			// Fleet Carrier
			this.fleetCarrierRearmTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_REARM_TOTAL");
			this.fleetCarrierTotalJumps = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_TOTAL_JUMPS");
			this.fleetCarrierExportTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_EXPORT_TOTAL");
			this.fleetCarrierImportTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_IMPORT_TOTAL");
			this.fleetCarrierRefuelTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_REFUEL_TOTAL");
			this.fleetCarrierRefuelProfit = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_REFUEL_PROFIT");
			this.fleetCarrierRepairsTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_REPAIRS_TOTAL");
			this.fleetCarrierShipyardSold = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_SHIPYARD_SOLD");
			this.fleetCarrierOutfittingSold = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_OUTFITTING_SOLD");
			this.fleetCarrierShipyardProfit = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_SHIPYARD_PROFIT");
			this.fleetCarrierVouchersProfit = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_VOUCHERS_PROFIT");
			this.fleetCarrierTradespendTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_TRADESPEND_TOTAL");
			this.fleetCarrierOutfittingProfit = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_OUTFITTING_PROFIT");
			this.fleetCarrierStolenspendTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_STOLENSPEND_TOTAL");
			this.fleetCarrierTradeprofitTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_TRADEPROFIT_TOTAL");
			this.fleetCarrierVouchersRedeemed = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_VOUCHERS_REDEEMED");
			this.fleetCarrierStolenprofitTotal = JsonUtils.pullLong(fleetCarrier, "FLEETCARRIER_STOLENPROFIT_TOTAL");
			this.fleetCarrierDistanceTravelled = JsonUtils.pullString(fleetCarrier, "FLEETCARRIER_DISTANCE_TRAVELLED");
		}
		JsonObject cqc = JsonUtils.pullJsonObject(jsonEvent, "CQC");

		// Crime
		this.totalFines = JsonUtils.pullLong(crime, "Total_Fines");
		this.totalBounties = JsonUtils.pullLong(crime, "Total_Bounties");
		this.bountiesReceived = JsonUtils.pullInt(crime, "Bounties_Received");
		this.notoriety = JsonUtils.pullInt(crime, "Notoriety");
		this.fines = JsonUtils.pullInt(crime, "Fines");
		this.highestBounty = JsonUtils.pullInt(crime, "Highest_Bounty");

		// Smuggling
		this.blackMarketsProfit = JsonUtils.pullLong(smuggling, "Black_Markets_Profits");
		this.averageSmugglingProfit = JsonUtils.pullLong(smuggling, "Average_Profit");
		this.blackMartketsTradedWith = JsonUtils.pullInt(smuggling, "Black_Markets_Traded_With");
		this.ressourcesSmuggled = JsonUtils.pullInt(smuggling, "Resources_Smuggled");
		this.highestSingleSmugglingTransaction = JsonUtils.pullInt(smuggling, "Highest_Single_Transaction");

		// Trading
		this.marketProfit = JsonUtils.pullLong(trading, "Market_Profits");
		this.marketsTradedWith = JsonUtils.pullInt(trading, "Markets_Traded_With");
		this.ressourcesTraded = JsonUtils.pullInt(trading, "Resources_Traded");
		this.averageTradingProfit = JsonUtils.pullInt(trading, "Average_Profit");
		this.highestSingleTradingTransaction = JsonUtils.pullInt(trading, "Highest_Single_Transaction");

		// Mining
		this.miningProfits = JsonUtils.pullLong(mining, "Mining_Profits");
		this.quantityMined = JsonUtils.pullInt(mining, "Quantity_Mined");
		this.materialsCollected = JsonUtils.pullInt(mining, "Materials_Collected");

		// Exploration
		this.explorationProfits = JsonUtils.pullLong(exploration, "Exploration_Profits");
		this.systemsVisited = JsonUtils.pullInt(exploration, "Systems_Visited");
		this.planetsScannedToLevel2 = JsonUtils.pullInt(exploration, "Planets_Scanned_To_Level_2");
		this.planetsScannedToLevel3 = JsonUtils.pullInt(exploration, "Planets_Scanned_To_Level_3");
		this.efficientScans = JsonUtils.pullInt(exploration, "Efficient_Scans");
		this.highestPayout = JsonUtils.pullInt(exploration, "Highest_Payout");
		this.totalHyperspaceDistance = JsonUtils.pullInt(exploration, "Total_Hyperspace_Distance");
		this.totalHyperspaceJumps = JsonUtils.pullInt(exploration, "Total_Hyperspace_Jumps");
		this.greatestDistanceFromStart = JsonUtils.pullInt(exploration, "Greatest_Distance_From_Start");
		this.timePlayed = JsonUtils.pullInt(exploration, "Time_Played");

		// Search & Rescue
		this.searchRescueProfit = JsonUtils.pullLong(searchAndRescue, "SearchRescue_Profit");
		this.searchRescueTraded = JsonUtils.pullInt(searchAndRescue, "SearchRescue_Traded");
		this.searchRescueCount = JsonUtils.pullInt(searchAndRescue, "SearchRescue_Count");

		// Passengers
		this.passengersMissionsAccepted = JsonUtils.pullInt(passengers, "Passengers_Missions_Accepted");
		this.passengersMissionsDisgruntled = JsonUtils.pullInt(passengers, "Passengers_Missions_Disgruntled");
		this.passengersMissionsBulk = JsonUtils.pullInt(passengers, "Passengers_Missions_Bulk");
		this.passengersMissionsVIP = JsonUtils.pullInt(passengers, "Passengers_Missions_VIP");
		this.passengersMissionsDelivered = JsonUtils.pullInt(passengers, "Passengers_Missions_Delivered");
		this.passengersMissionsEjected = JsonUtils.pullInt(passengers, "Passengers_Missions_Ejected");

        if (cqc != null) {
            //CQC
            this.cqcKD = JsonUtils.pullDouble(cqc, "CQC_KD");
            this.cqcWL = JsonUtils.pullDouble(cqc, "CQC_WL");
            this.cqcKills = JsonUtils.pullLong(cqc, "CQC_Kills");
            this.cqcTimePlayed = JsonUtils.pullLong(cqc, "CQC_Time_Played");
            this.cqcCreditsEarned = JsonUtils.pullLong(cqc, "CQC_Credits_Earned");

        }

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }
}
