/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 13:54
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MissionAcceptedEvent extends Event {
	
	private String faction, name, localisedName, targetFaction, destinationSystem, destinationStation, influence, reputation;
	private Long reward, missionId, expiry;
	
	public MissionAcceptedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.localisedName = JsonUtils.pullString(jsonEvent, "LocalisedName");
        this.targetFaction = JsonUtils.pullString(jsonEvent, "TargetFaction");
        this.destinationSystem = JsonUtils.pullString(jsonEvent, "DestinationSystem");
        this.destinationStation = JsonUtils.pullString(jsonEvent, "DestinationStation");
        this.expiry = GameFilesUtils.getTimeMillis(JsonUtils.pullString(jsonEvent, "Expiry"));
        this.influence = JsonUtils.pullString(jsonEvent, "Influence");
        this.reputation = JsonUtils.pullString(jsonEvent, "Reputation");
        this.reward = JsonUtils.pullLong(jsonEvent, "Reward");
        this.missionId = JsonUtils.pullLong(jsonEvent, "MissionID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getFaction() {
		return faction;
	}

	public String getName() {
		return name;
	}

	public String getLocalisedName() {
		return localisedName;
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

	public Long getExpiry() {
		return expiry;
	}

	public String getInfluence() {
		return influence;
	}

	public String getReputation() {
		return reputation;
	}

	public Long getReward() {
		return reward;
	}

	public Long getMissionId() {
		return missionId;
	}

}
