package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class RepairAllEvent extends Event {
	
	private Long cost;

	public RepairAllEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.cost = JsonUtils.pullLong(jsonEvent, "Cost");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getCost() {
		return cost;
	}

}
