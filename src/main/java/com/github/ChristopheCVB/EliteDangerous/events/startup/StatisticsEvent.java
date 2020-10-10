package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class StatisticsEvent extends Event {
	//    TODO: i dont know what to do here to can you do it?

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
	
	public StatisticsEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		JsonObject bankAccount = JsonUtils.pullJsonObject(jsonEvent, "Bank_Account");
		JsonObject combat = JsonUtils.pullJsonObject(jsonEvent, "Combat");
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

		// Bank Account
		this.currentWealth = JsonUtils.pullLong(bankAccount, "Current_Wealth");
		this.spentOnShips = JsonUtils.pullLong(bankAccount, "Spent_On_Ships");
		this.spentOnOutfitting = JsonUtils.pullLong(bankAccount, "Spent_On_Outfitting");
		this.spentOnRepairs = JsonUtils.pullLong(bankAccount, "Spent_On_Repairs");
		this.spentOnFuel = JsonUtils.pullLong(bankAccount, "Spent_On_Fuel");
		this.spentOnAmmoConsumables = JsonUtils.pullLong(bankAccount, "Spent_On_Ammo_Consumables");
		this.spentOnInsurance = JsonUtils.pullLong(bankAccount, "Spent_On_Insurance");
		this.insuranceClaims = JsonUtils.pullInt(bankAccount, "Insurance_Claims");
		this.ownedShipCount = JsonUtils.pullInt(bankAccount, "Owned_Ship_Count");

		// Combat
		this.bountyHuntingProfit = JsonUtils.pullLong(combat, "Bounty_Hunting_Profit");
		this.combatBondsProfit = JsonUtils.pullLong(combat, "Combat_Bond_Profits");
		this.assassinationProfits = JsonUtils.pullLong(combat, "Assassination_Profits");
		this.bountiesClaimed = JsonUtils.pullInt(combat, "Bounties_Claimed");
		this.combatBonds = JsonUtils.pullInt(combat, "Combat_Bonds");
		this.assassinations = JsonUtils.pullInt(combat, "Assassinations");
		this.highestSingleReward = JsonUtils.pullInt(combat, "Highest_Single_Reward");
		this.skimmersKilled = combat.has("Skimmers_Killed") ? JsonUtils.pullInt(combat, "Skimmers_Killed") : null;

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

	public Long getCurrentWealth() {
		return currentWealth;
	}

	public Long getSpentOnShips() {
		return spentOnShips;
	}

	public Long getSpentOnOutfitting() {
		return spentOnOutfitting;
	}

	public Long getSpentOnRepairs() {
		return spentOnRepairs;
	}

	public Long getSpentOnFuel() {
		return spentOnFuel;
	}

	public Long getSpentOnAmmoConsumables() {
		return spentOnAmmoConsumables;
	}

	public Long getSpentOnInsurance() {
		return spentOnInsurance;
	}

	public Long getBountyHuntingProfit() {
		return bountyHuntingProfit;
	}

	public Long getCombatBondsProfit() {
		return combatBondsProfit;
	}

	public Long getAssassinationProfits() {
		return assassinationProfits;
	}

	public Long getTotalFines() {
		return totalFines;
	}

	public Long getTotalBounties() {
		return totalBounties;
	}

	public Long getBlackMarketsProfit() {
		return blackMarketsProfit;
	}

	public Long getAverageSmugglingProfit() {
		return averageSmugglingProfit;
	}

	public Long getMarketProfit() {
		return marketProfit;
	}

	public Long getMiningProfits() {
		return miningProfits;
	}

	public Long getExplorationProfits() {
		return explorationProfits;
	}

	public Long getSearchRescueProfit() {
		return searchRescueProfit;
	}

	public Long getTotalNpcCrewWages() {
		return totalNpcCrewWages;
	}

	public Long getFleetCarrierRearmTotal() {
		return fleetCarrierRearmTotal;
	}

	public Long getFleetCarrierExportTotal() {
		return fleetCarrierExportTotal;
	}

	public Long getFleetCarrierImportTotal() {
		return fleetCarrierImportTotal;
	}

	public Long getFleetCarrierRefuelTotal() {
		return fleetCarrierRefuelTotal;
	}

	public Long getFleetCarrierRefuelProfit() {
		return fleetCarrierRefuelProfit;
	}

	public Long getFleetCarrierRepairsTotal() {
		return fleetCarrierRepairsTotal;
	}

	public Long getFleetCarrierShipyardSold() {
		return fleetCarrierShipyardSold;
	}

	public Long getFleetCarrierOutfittingSold() {
		return fleetCarrierOutfittingSold;
	}

	public Long getFleetCarrierShipyardProfit() {
		return fleetCarrierShipyardProfit;
	}

	public Long getFleetCarrierVouchersProfit() {
		return fleetCarrierVouchersProfit;
	}

	public Long getFleetCarrierTradespendTotal() {
		return fleetCarrierTradespendTotal;
	}

	public Long getFleetCarrierOutfittingProfit() {
		return fleetCarrierOutfittingProfit;
	}

	public Long getFleetCarrierStolenspendTotal() {
		return fleetCarrierStolenspendTotal;
	}

	public Long getFleetCarrierTradeprofitTotal() {
		return fleetCarrierTradeprofitTotal;
	}

	public Long getFleetCarrierVouchersRedeemed() {
		return fleetCarrierVouchersRedeemed;
	}

	public Long getFleetCarrierStolenprofitTotal() {
		return fleetCarrierStolenprofitTotal;
	}

	public Long getCqcKills() {
		return cqcKills;
	}

	public Long getCqcTimePlayed() {
		return cqcTimePlayed;
	}

	public Long getCqcCreditsEarned() {
		return cqcCreditsEarned;
	}

	public Long getFleetCarrierTotalJumps() {
		return fleetCarrierTotalJumps;
	}

	public Integer getBountiesReceived() {
		return bountiesReceived;
	}

	public Integer getInsuranceClaims() {
		return insuranceClaims;
	}

	public Integer getOwnedShipCount() {
		return ownedShipCount;
	}

	public Integer getBountiesClaimed() {
		return bountiesClaimed;
	}

	public Integer getCombatBonds() {
		return combatBonds;
	}

	public Integer getAssassinations() {
		return assassinations;
	}

	public Integer getHighestSingleReward() {
		return highestSingleReward;
	}

	public Integer getSkimmersKilled() {
		return skimmersKilled;
	}

	public Integer getNotoriety() {
		return notoriety;
	}

	public Integer getFines() {
		return fines;
	}

	public Integer getHighestBounty() {
		return highestBounty;
	}

	public Integer getBlackMartketsTradedWith() {
		return blackMartketsTradedWith;
	}

	public Integer getRessourcesSmuggled() {
		return ressourcesSmuggled;
	}

	public Integer getHighestSingleSmugglingTransaction() {
		return highestSingleSmugglingTransaction;
	}

	public Integer getMarketsTradedWith() {
		return marketsTradedWith;
	}

	public Integer getRessourcesTraded() {
		return ressourcesTraded;
	}

	public Integer getAverageTradingProfit() {
		return averageTradingProfit;
	}

	public Integer getHighestSingleTradingTransaction() {
		return highestSingleTradingTransaction;
	}

	public Integer getQuantityMined() {
		return quantityMined;
	}

	public Integer getMaterialsCollected() {
		return materialsCollected;
	}

	public Integer getSystemsVisited() {
		return systemsVisited;
	}

	public Integer getPlanetsScannedToLevel2() {
		return planetsScannedToLevel2;
	}

	public Integer getPlanetsScannedToLevel3() {
		return planetsScannedToLevel3;
	}

	public Integer getEfficientScans() {
		return efficientScans;
	}

	public Integer getHighestPayout() {
		return highestPayout;
	}

	public Integer getTotalHyperspaceDistance() {
		return totalHyperspaceDistance;
	}

	public Integer getTotalHyperspaceJumps() {
		return totalHyperspaceJumps;
	}

	public Integer getGreatestDistanceFromStart() {
		return greatestDistanceFromStart;
	}

	public Integer getTimePlayed() {
		return timePlayed;
	}

	public Integer getPassengersMissionsAccepted() {
		return passengersMissionsAccepted;
	}

	public Integer getPassengersMissionsDisgruntled() {
		return passengersMissionsDisgruntled;
	}

	public Integer getPassengersMissionsBulk() {
		return passengersMissionsBulk;
	}

	public Integer getPassengersMissionsVIP() {
		return passengersMissionsVIP;
	}

	public Integer getPassengersMissionsDelivered() {
		return passengersMissionsDelivered;
	}

	public Integer getPassengersMissionsEjected() {
		return passengersMissionsEjected;
	}

	public Integer getSearchRescueTraded() {
		return searchRescueTraded;
	}

	public Integer getSearchRescueCount() {
		return searchRescueCount;
	}

	public Integer getTotalTGEncounters() {
		return totalTGEncounters;
	}

	public Integer gettGScoutCount() {
		return tGScoutCount;
	}

	public Integer getEngineersUsedCount() {
		return engineersUsedCount;
	}

	public Integer getTotalRecipesGenerated() {
		return totalRecipesGenerated;
	}

	public Integer getRecipesGeneratedRank1() {
		return recipesGeneratedRank1;
	}

	public Integer getRecipesGeneratedRank2() {
		return recipesGeneratedRank2;
	}

	public Integer getRecipesGeneratedRank3() {
		return recipesGeneratedRank3;
	}

	public Integer getRecipesGeneratedRank4() {
		return recipesGeneratedRank4;
	}

	public Integer getRecipesGeneratedRank5() {
		return recipesGeneratedRank5;
	}

	public Integer getHiredNpcCrew() {
		return hiredNpcCrew;
	}

	public Integer getFiredNpcCrew() {
		return firedNpcCrew;
	}

	public Integer getTotalMulticrewTime() {
		return totalMulticrewTime;
	}

	public Integer getTotalMulticrewTimeGunner() {
		return totalMulticrewTimeGunner;
	}

	public Integer getTotalMulticrewTimeFighter() {
		return totalMulticrewTimeFighter;
	}

	public Integer getTotalMulticrewCredits() {
		return totalMulticrewCredits;
	}

	public Integer getTotalMulticrewFines() {
		return totalMulticrewFines;
	}

	public Integer getMaterialTraderTradesCompledted() {
		return materialTraderTradesCompledted;
	}

	public Integer getMaterialTraderMaterialsTraded() {
		return materialTraderMaterialsTraded;
	}

	public Integer getMaterialTraderEncodedMaterialsTraded() {
		return materialTraderEncodedMaterialsTraded;
	}

	public Integer getMaterialTraderGrade1Traded() {
		return materialTraderGrade1Traded;
	}

	public Integer getMaterialTraderGrade2Traded() {
		return materialTraderGrade2Traded;
	}

	public Integer getMaterialTraderGrade3Traded() {
		return materialTraderGrade3Traded;
	}

	public Integer getMaterialTraderGrade4Traded() {
		return materialTraderGrade4Traded;
	}

	public Integer getMaterialTraderGrade5Traded() {
		return materialTraderGrade5Traded;
	}

	public String getLastTGEncounterSystem() {
		return lastTGEncounterSystem;
	}

	public String getLastTGEncounterTime() {
		return lastTGEncounterTime;
	}

	public String getLastTGEncounterShip() {
		return lastTGEncounterShip;
	}

	public String getFleetCarrierDistanceTravelled() {
		return fleetCarrierDistanceTravelled;
	}

	public Double getCqcKD() {
		return cqcKD;
	}

	public Double getCqcWL() {
		return cqcWL;
	}
	
}
