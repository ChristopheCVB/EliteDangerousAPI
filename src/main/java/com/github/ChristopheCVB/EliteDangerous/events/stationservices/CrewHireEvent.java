package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewHireEvent extends Event {
	public String name;
	public String faction;
	public Integer crewID;
	public Integer cost;
	public Integer combatRank;
}
