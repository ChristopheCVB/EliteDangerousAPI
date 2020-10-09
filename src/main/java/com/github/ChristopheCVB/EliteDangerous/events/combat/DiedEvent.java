package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class DiedEvent extends Event {
	
	private String killerName, killerShip, killerRank;

	public DiedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.killerName = JsonUtils.pullString(jsonEvent, "KillerName");
        this.killerShip = JsonUtils.pullString(jsonEvent, "KillerShip");
        this.killerRank = JsonUtils.pullString(jsonEvent, "KillerRank");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getKillerName() {
		return killerName;
	}

	public String getKillerShip() {
		return killerShip;
	}

	public String getKillerRank() {
		return killerRank;
	}

}
