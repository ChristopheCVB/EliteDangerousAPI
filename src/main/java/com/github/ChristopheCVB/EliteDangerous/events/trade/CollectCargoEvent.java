package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CollectCargoEvent extends Event {
	
	private String type;
	private Long missionID;
	private Boolean stolen;
	
	public CollectCargoEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.missionID = JsonUtils.pullLong(jsonEvent, "MissionID");
        this.stolen = JsonUtils.pullBoolean(jsonEvent, "Stolen");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getStolen() {
		return stolen;
	}

}
