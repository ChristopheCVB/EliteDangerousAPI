package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewFireEvent extends Event {
	
	public String name;
	public Integer crewID;
	
	public CrewFireEvent(String timestamp) {
		super(timestamp);
	}
}
