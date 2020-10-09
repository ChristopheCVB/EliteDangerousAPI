/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:55
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SearchAndRescueEvent extends Event {
	
	private Long marketId, reward;
	private String name, nameLocalised;
	private Integer count;
	
	public SearchAndRescueEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.reward = JsonUtils.pullLong(jsonEvent, "Reward");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.nameLocalised = JsonUtils.pullString(jsonEvent, "Name_Localised");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketId() {
		return marketId;
	}

	public Long getReward() {
		return reward;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public Integer getCount() {
		return count;
	}

}
