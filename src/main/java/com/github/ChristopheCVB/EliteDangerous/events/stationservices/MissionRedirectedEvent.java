package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionRedirectedEvent extends Event {
	public String name;
	public String newDestinationStation;
	public String newDestinationSystem;
	public String oldDestinationStation;
	public String oldDestinationSystem;
	public Long missionID;
}
