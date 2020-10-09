package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CrewAssignEvent extends Event {
	
	private String name, role;
	private Integer crewID;
	
	public CrewAssignEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.role = JsonUtils.pullString(jsonEvent, "Role");
        this.crewID = JsonUtils.pullInt(jsonEvent, "CrewID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	public Integer getCrewID() {
		return crewID;
	}

}
