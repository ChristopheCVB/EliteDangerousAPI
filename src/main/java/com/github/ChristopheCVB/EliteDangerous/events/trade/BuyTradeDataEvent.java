package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class BuyTradeDataEvent extends Event {
	
	private String system;
	private Integer cost;
	
	public BuyTradeDataEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.system = JsonUtils.pullString(jsonEvent, "System");
        this.cost = JsonUtils.pullInt(jsonEvent, "Cost");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSystem() {
		return system;
	}

	public Integer getCost() {
		return cost;
	}
	
}
