package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CrewHireEvent extends Event {
	
	private String name, faction;
	private Integer crewID, cost, combatRank;
	
	public CrewHireEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.crewID = JsonUtils.pullInt(jsonEvent, "CrewID");
        this.cost = JsonUtils.pullInt(jsonEvent, "Cost");
        this.combatRank = JsonUtils.pullInt(jsonEvent, "CombatRank");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getFaction() {
		return faction;
	}

	public Integer getCrewID() {
		return crewID;
	}

	public Integer getCost() {
		return cost;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
