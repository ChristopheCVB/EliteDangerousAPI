package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class HullDamageEvent extends Event {
	
	private Double health;
	private Boolean playerPilot, fighter;
	
	public HullDamageEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.health = JsonUtils.pullDouble(jsonEvent, "Health");
        this.playerPilot = JsonUtils.pullBoolean(jsonEvent, "PlayerPilot");
        this.fighter = JsonUtils.pullBoolean(jsonEvent, "Fighter");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Double getHealth() {
		return health;
	}

	public Boolean getPlayerPilot() {
		return playerPilot;
	}

	public Boolean getFighter() {
		return fighter;
	}
	
}
