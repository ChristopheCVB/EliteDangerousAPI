package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class RepairEvent extends Event {
	
	private String item;
	private Long cost;
	
	public RepairEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.item = JsonUtils.pullString(jsonEvent, "Item");
        this.cost = JsonUtils.pullLong(jsonEvent, "Cost");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getItem() {
		return item;
	}

	public Long getCost() {
		return cost;
	}

}
