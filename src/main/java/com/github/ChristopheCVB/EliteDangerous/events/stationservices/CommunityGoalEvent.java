package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CommunityGoalEvent extends Event {
	
	private Integer cgid, playerContribution, numContributors, topRankSize, playerPercentileBand, bonus;
	private String title, systemName, marketName, tierReached;
	private Long expiry;
	private Boolean isComplete, playerInTopRank;
	
	public CommunityGoalEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.cgid = JsonUtils.pullInt(jsonEvent, "CGID");
        this.playerContribution = JsonUtils.pullInt(jsonEvent, "PlayerContribution");
        this.numContributors = JsonUtils.pullInt(jsonEvent, "NumContributors");
        this.topRankSize = JsonUtils.pullInt(jsonEvent, "TopRankSize");
        this.playerPercentileBand = JsonUtils.pullInt(jsonEvent, "PlayerPercentileBand");
        this.bonus = JsonUtils.pullInt(jsonEvent, "Bonus");
        this.title = JsonUtils.pullString(jsonEvent, "Title");
        this.systemName = JsonUtils.pullString(jsonEvent, "SystemName");
        this.marketName = JsonUtils.pullString(jsonEvent, "MarketName");
        this.tierReached = JsonUtils.pullString(jsonEvent, "TierReached");
        this.expiry = GameFilesUtils.getTimeMillis(JsonUtils.pullString(jsonEvent, "Expiry"));
        this.isComplete = JsonUtils.pullBoolean(jsonEvent, "IsComplete");
        this.playerInTopRank = JsonUtils.pullBoolean(jsonEvent, "PlayerInTopRank");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCgid() {
		return cgid;
	}

	public Integer getPlayerContribution() {
		return playerContribution;
	}

	public Integer getNumContributors() {
		return numContributors;
	}

	public Integer getTopRankSize() {
		return topRankSize;
	}

	public Integer getPlayerPercentileBand() {
		return playerPercentileBand;
	}

	public Integer getBonus() {
		return bonus;
	}

	public String getTitle() {
		return title;
	}

	public String getSystemName() {
		return systemName;
	}

	public String getMarketName() {
		return marketName;
	}

	public String getTierReached() {
		return tierReached;
	}

	public Long getExpiry() {
		return expiry;
	}

	public Boolean getIsComplete() {
		return isComplete;
	}

	public Boolean getPlayerInTopRank() {
		return playerInTopRank;
	}

}
