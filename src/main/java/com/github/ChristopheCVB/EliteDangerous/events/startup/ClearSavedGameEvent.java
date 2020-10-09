package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ClearSavedGameEvent extends Event {
	
	private String name;
	private String FID;
	
	public ClearSavedGameEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.FID = JsonUtils.pullString(jsonEvent, "FID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getFID() {
		return FID;
	}

}
