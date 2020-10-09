package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class BuyAmmoEvent extends Event {
	
	private Integer cost;

	public BuyAmmoEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.cost = JsonUtils.pullInt(jsonEvent, "Cost");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCost() {
		return cost;
	}

}
