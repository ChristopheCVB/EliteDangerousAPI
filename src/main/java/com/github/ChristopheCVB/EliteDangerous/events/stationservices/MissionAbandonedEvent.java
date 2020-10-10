package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionAbandonedEvent extends Event {
	public String name;
	public Long missionID;
	
	public MissionAbandonedEvent(String timestamp) {
        super(timestamp);
    }
}
