package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionAcceptedEvent extends Event {
	public String faction;
	public String name;
	public String localisedName;
	public String targetFaction;
	public String destinationSystem;
	public String destinationStation;
	public String influence;
	public String reputation;
	public Long reward;
	public Long missionID;
	public Long expiry;
	
	public MissionAcceptedEvent(String timestamp) {
        super(timestamp);
    }
}
