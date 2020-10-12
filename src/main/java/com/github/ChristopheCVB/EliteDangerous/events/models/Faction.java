package com.github.ChristopheCVB.EliteDangerous.events.models;

import java.util.List;

public class Faction {
	public String name;
	public String factionState;
	public String government;
	public String allegiance;
	public String happiness;
	public Double myReputation;
	public Double influence;
	public List<FactionState> activeStates;
	public List<FactionState> pendingStates;
	public List<FactionState> recoveringStates;
	public Boolean squadronSystem;
	public Boolean happiestSystem;
	public Boolean homeSystem;
}
