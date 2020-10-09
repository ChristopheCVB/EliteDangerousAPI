package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class InterdictionEvent extends Event {
	
	private Boolean success, isPlayer;
	private String interdictor, faction, power;
	private Integer combatRank;
	
	public InterdictionEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.success = JsonUtils.pullBoolean(jsonEvent, "Submitted");
        this.isPlayer = JsonUtils.pullBoolean(jsonEvent, "IsPlayer");
        this.interdictor = JsonUtils.pullString(jsonEvent, "Interdictor");
        this.faction = isPlayer ? null : JsonUtils.pullString(jsonEvent, "Faction");
        this.power = isPlayer ? null : JsonUtils.pullString(jsonEvent, "Power");
        this.combatRank = isPlayer ? JsonUtils.pullInt(jsonEvent, "CombatRank") : null;

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Boolean getSuccess() {
		return success;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

	public String getInterdictor() {
		return interdictor;
	}

	public String getFaction() {
		return faction;
	}

	public String getPower() {
		return power;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
