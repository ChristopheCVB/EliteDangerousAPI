package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class NewCommanderEvent extends Event {
	
	private String name, FID, starterPackage;

	public NewCommanderEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.FID = JsonUtils.pullString(jsonEvent, "FID");
        this.starterPackage = JsonUtils.pullString(jsonEvent, "starterPackage");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getFID() {
		return FID;
	}

	public String getStarterPackage() {
		return starterPackage;
	}	

}
