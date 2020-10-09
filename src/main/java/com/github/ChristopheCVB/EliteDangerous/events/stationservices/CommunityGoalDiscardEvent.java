package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CommunityGoalDiscardEvent extends Event {
	
	private Integer cgid;
	private String name, system;
	
	public CommunityGoalDiscardEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.cgid = JsonUtils.pullInt(jsonEvent, "CGID");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.system = JsonUtils.pullString(jsonEvent, "System");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCgid() {
		return cgid;
	}

	public String getName() {
		return name;
	}

	public String getSystem() {
		return system;
	}

}
