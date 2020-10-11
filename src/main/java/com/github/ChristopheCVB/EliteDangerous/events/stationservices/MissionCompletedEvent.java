package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionCompletedEvent extends Event {
	public String faction;
	public String name;
	public String targetFaction;
	public String destinationSystem;
	public String destinationStation;
	public Long missionID;
	public Long reward;
}
