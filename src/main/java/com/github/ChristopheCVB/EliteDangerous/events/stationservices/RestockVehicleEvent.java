package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class RestockVehicleEvent extends Event {
	
	private String type, loadout;
	private Long cost;
	private Integer count;
	
	public RestockVehicleEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.loadout = JsonUtils.pullString(jsonEvent, "Loadout");
        this.cost = JsonUtils.pullLong(jsonEvent, "Cost");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public String getLoadout() {
		return loadout;
	}

	public Long getCost() {
		return cost;
	}

	public Integer getCount() {
		return count;
	}

}
