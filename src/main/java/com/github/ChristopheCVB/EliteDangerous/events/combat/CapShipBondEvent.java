package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CapShipBondEvent extends Event {
	
	private String victimFaction, awardingFaction;
	private Integer reward;
	
	public CapShipBondEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.victimFaction = JsonUtils.pullString(jsonEvent, "VictimFaction");
        this.awardingFaction = JsonUtils.pullString(jsonEvent, "AwardingFaction");
        this.reward = JsonUtils.pullInt(jsonEvent, "Reward");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getVictimFaction() {
		return victimFaction;
	}

	public String getAwardingFaction() {
		return awardingFaction;
	}

	public Integer getReward() {
		return reward;
	}

}
