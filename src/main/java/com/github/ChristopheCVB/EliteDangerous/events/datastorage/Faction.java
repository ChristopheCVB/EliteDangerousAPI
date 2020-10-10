package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import java.util.ArrayList;

public class Faction {
	public String name;
	public String factionState;
	public String government;
	public String allegiance;
	public String happiness;
	public Double myReputation;
	public Double influence;
	public ArrayList<FactionState> activeStates;
	public ArrayList<FactionState> pendingStates;
	public ArrayList<FactionState> recoveringStates;
	public Boolean squadronSystem;
	public Boolean happiestSystem;
	public Boolean homeSystem;
}
