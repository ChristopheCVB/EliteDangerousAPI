package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class Faction {
	
	private String name, factionState, goverment, allegiance, happiness;
	private Double myReputation, influence;
	private FactionState activeStates, pendingStates, recoveringStates;
	private Boolean squadronSystem, happiestSystem, homeSystem;
	
	public Faction(String name, String factionState, String goverment, String allegiance, String happiness,
			Double myReputation, Double influence, FactionState activeStates, FactionState pendingStates,
			FactionState recoveringStates, Boolean squadronSystem, Boolean happiestSystem, Boolean homeSystem) {
		this.name = name;
		this.factionState = factionState;
		this.goverment = goverment;
		this.allegiance = allegiance;
		this.happiness = happiness;
		this.myReputation = myReputation;
		this.influence = influence;
		this.activeStates = activeStates;
		this.pendingStates = pendingStates;
		this.recoveringStates = recoveringStates;
		this.squadronSystem = squadronSystem;
		this.happiestSystem = happiestSystem;
		this.homeSystem = homeSystem;
	}

	public String getName() {
		return name;
	}

	public String getFactionState() {
		return factionState;
	}

	public String getGoverment() {
		return goverment;
	}

	public String getAllegiance() {
		return allegiance;
	}

	public String getHappiness() {
		return happiness;
	}

	public Double getMyReputation() {
		return myReputation;
	}

	public Double getInfluence() {
		return influence;
	}

	public FactionState getActiveStates() {
		return activeStates;
	}

	public FactionState getPendingStates() {
		return pendingStates;
	}

	public FactionState getRecoveringStates() {
		return recoveringStates;
	}

	public Boolean getSquadronSystem() {
		return squadronSystem;
	}

	public Boolean getHappiestSystem() {
		return happiestSystem;
	}

	public Boolean getHomeSystem() {
		return homeSystem;
	}
	
}
