package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CommunityGoalRewardEvent extends Event{
	
	private Integer cgid, reward;
	private String name, system;
	
	public CommunityGoalRewardEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.cgid = JsonUtils.pullInt(jsonEvent, "CGID");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.system = JsonUtils.pullString(jsonEvent, "System");
        this.reward = JsonUtils.pullInt(jsonEvent, "Reward");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCgid() {
		return cgid;
	}

	public Integer getReward() {
		return reward;
	}

	public String getName() {
		return name;
	}

	public String getSystem() {
		return system;
	}

}
