package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class InterdictedEvent extends Event {
	
	private Boolean submitted, isPlayer;
	private String interdictor, faction, power;
	private Integer combatRank;
	
	public InterdictedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.submitted = JsonUtils.pullBoolean(jsonEvent, "Submitted");
        this.isPlayer = JsonUtils.pullBoolean(jsonEvent, "IsPlayer");
        this.interdictor = JsonUtils.pullString(jsonEvent, "Interdictor");
        this.combatRank = isPlayer ? JsonUtils.pullInt(jsonEvent, "CombatRank") : null;
        this.faction = isPlayer ? null : JsonUtils.pullString(jsonEvent, "Faction");
        this.power = isPlayer ? null : JsonUtils.pullString(jsonEvent, "Power");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public boolean isSubmitted() {
		return submitted;
	}

	public boolean isPlayer() {
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
