package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.station.Discovered;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class MultiSellExplorationDataEvent extends Event {
	
	private List<Discovered> discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.discovered = GameFilesUtils.createDiscoveredList(JsonUtils.pullJsonArray(jsonEvent, "Discovered"));
        this.baseValue = JsonUtils.pullInt(jsonEvent, "BaseValue");
        this.totalEarnings = JsonUtils.pullInt(jsonEvent, "TotalEarnings");
        this.bonus = JsonUtils.pullInt(jsonEvent, "Bonus");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<Discovered> getDiscovered() {
		return discovered;
	}

	public Integer getBaseValue() {
		return baseValue;
	}

	public Integer getTotalEarnings() {
		return totalEarnings;
	}

	public Integer getBonus() {
		return bonus;
	}
	
}
