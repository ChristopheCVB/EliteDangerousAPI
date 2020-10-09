package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ProgressEvent extends Event {
	
	private Integer combat, trade, explore, empire, federation, cqc;

	public ProgressEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.combat = JsonUtils.pullInt(jsonEvent, "Combat");
        this.trade = JsonUtils.pullInt(jsonEvent, "Trade");
        this.explore = JsonUtils.pullInt(jsonEvent, "Explore");
        this.empire = JsonUtils.pullInt(jsonEvent, "Empire");
        this.federation = JsonUtils.pullInt(jsonEvent, "Federation");
        this.cqc = JsonUtils.pullInt(jsonEvent, "CQC");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCombatRankProgress() {
		return combat;
	}

	public Integer getTradeRankProgress() {
		return trade;
	}

	public Integer getExploreRankProgress() {
		return explore;
	}

	public Integer getEmpireRankProgress() {
		return empire;
	}

	public Integer getFederationRankProgress() {
		return federation;
	}

	public Integer getCQCRankProgress() {
		return cqc;
	}
	
}
