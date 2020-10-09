/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:04
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MissionCompletedEvent extends Event {
	
	private String faction, name, targetFaction, destinationSystem, destinationStation;
	private Long missionId, reward;
	
	public MissionCompletedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.targetFaction = JsonUtils.pullString(jsonEvent, "TargetFaction");
        this.destinationSystem = JsonUtils.pullString(jsonEvent, "DestinationSystem");
        this.destinationStation = JsonUtils.pullString(jsonEvent, "DestinationStation");
        this.missionId = JsonUtils.pullLong(jsonEvent, "MissionID");
        this.reward = JsonUtils.pullLong(jsonEvent, "Reward");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getFaction() {
		return faction;
	}

	public String getName() {
		return name;
	}

	public String getTargetFaction() {
		return targetFaction;
	}

	public String getDestinationSystem() {
		return destinationSystem;
	}

	public String getDestinationStation() {
		return destinationStation;
	}

	public Long getMissionId() {
		return missionId;
	}

	public Long getReward() {
		return reward;
	}

}
