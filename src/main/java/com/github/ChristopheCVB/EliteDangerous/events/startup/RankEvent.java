package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.localiser.*;
import com.google.gson.JsonObject;

public class RankEvent extends Event {
	
	private Integer combat, trade, explore, empire, federation, cqc;

	public RankEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.combat = JsonUtils.pullInt(jsonEvent, "Combat");
        this.trade = JsonUtils.pullInt(jsonEvent, "Trade");
        this.explore = JsonUtils.pullInt(jsonEvent, "Explore");
        this.empire = JsonUtils.pullInt(jsonEvent, "Empire");
        this.federation = JsonUtils.pullInt(jsonEvent, "Federation");
        this.cqc = JsonUtils.pullInt(jsonEvent, "CQC");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	/**
	 * Gets the Combat rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Combat Rank as Integer.
	 */
	public Integer getCombatRank() {
		return combat;
	}
	
	/**
	 * Gets Combat Rank as name.
	 * 
	 * @return String Combat Rank name.
	 */
	public String getCombatRankName() {
		return CombatRank.getLocalisedName(combat);
	}

	/**
	 * Gets Trade Rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Trade Rank as Integer.
	 */
	public Integer getTradeRank() {
		return trade;
	}
	
	/**
	 * Gets Trade Rank as name.
	 * 
	 * @return String Trade Rank name.
	 */
	public String getTradeRankName() {
		return TradeRank.getLocalisedName(trade);
	}

	/**
	 * Gets the Explore rank as an Integer between 0 - 8.
	 * 
	 * @return Integer Explore Rank as Integer.
	 */
	public Integer getExploreRank() {
		return explore;
	}
	
	/**
	 * Gets Explore Rank name.
	 * 
	 * @return String Explore Rank name.
	 */
	public String getExplorerRankName() {
		return ExplorationRank.getLocalisedName(explore);
	}

	/**
	 * Gets the Empire rank as an Integer between 0 - 14.
	 * 
	 * @return Integer Empire Rank as Integer.
	 */
	public Integer getEmpireRank() {
		return empire;
	}
	
	/**
	 * Gets Empire Rank name.
	 * 
	 * @return String Empire Rank name.
	 */
	public String getEmpireRankName() {
		return EmpireRank.getLocalisedName(empire);
	}

	/**
	 * Gets the Federation rank as an Integer between 0 - 14.
	 * 
	 * @return Integer Federation Rank as Integer.
	 */
	public Integer getFederationRank() {
		return federation;
	}
	
	/**
	 * Gets Federation Rank name.
	 * 
	 * @return String Federation Rank name.
	 */
	public String getFederationRankName() {
		return FederationRank.getLocalisedName(federation);
	}

	/**
	 * Gets the CQC rank as an Integer between 0 - 14.
	 * 
	 * @return Integer CQC Rank as Integer.
	 */
	public Integer getCQCRank() {
		return cqc;
	}
	

	/**
	 * Gets CQC Rank name.
	 * 
	 * @return String CQC Rank name.
	 */
	public String getCQCRankName() {
		return CQCRank.getLocalisedName(cqc);
	}
	
}
