package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class EscapeInterdictionEvent extends Event {
	
	private String interdictor;
	private Boolean isPlayer;
	
	public EscapeInterdictionEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.interdictor = JsonUtils.pullString(jsonEvent, "Interdictor");
        this.isPlayer = JsonUtils.pullBoolean(jsonEvent, "IsPlayer");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getInterdictor() {
		return interdictor;
	}

	public Boolean getIsPlayer() {
		return isPlayer;
	}

}
