package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SellExplorationDataEvent extends Event {
	
	private String[] systems, discovered;
	private Integer baseValue, bonus, totalEarnings;
	
	public SellExplorationDataEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.systems = GameFilesUtils.createDataSystemsList(JsonUtils.pullJsonArray(jsonEvent, "Systems"));
        this.discovered = GameFilesUtils.createDataDiscoveredList(JsonUtils.pullJsonArray(jsonEvent, "Discovered"));
        this.baseValue = JsonUtils.pullInt(jsonEvent, "BaseValue");
        this.bonus = JsonUtils.pullInt(jsonEvent, "Bonus");
        this.totalEarnings = JsonUtils.pullInt(jsonEvent, "TotalEarnings");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String[] getSystems() {
		return systems;
	}

	public String[] getDiscovered() {
		return discovered;
	}

	public Integer getBaseValue() {
		return baseValue;
	}

	public Integer getBonus() {
		return bonus;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

}
