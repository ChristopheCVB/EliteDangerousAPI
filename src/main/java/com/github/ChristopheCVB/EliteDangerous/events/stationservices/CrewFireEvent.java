package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CrewFireEvent extends Event {
	
	private String name;
	private Integer crewID;
	
	public CrewFireEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		this.name = JsonUtils.pullString(jsonEvent, "Name");
		this.crewID = JsonUtils.pullInt(jsonEvent, "CrewID");
	}

	public String getName() {
		return name;
	}

	public Integer getCrewID() {
		return crewID;
	}

}
