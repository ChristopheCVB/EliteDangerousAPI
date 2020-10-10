package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionFailedEvent extends Event {
	public String name;
	public Long missionID;
	
	public MissionFailedEvent(String timestamp) {
        super(timestamp);
    }
}
