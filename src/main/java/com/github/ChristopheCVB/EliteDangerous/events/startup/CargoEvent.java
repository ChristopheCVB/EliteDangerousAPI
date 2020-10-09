package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.CargoInventory;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class CargoEvent extends Event {

	private String vessel;
	private Integer count;
	private List<CargoInventory> inventory;
	
	public CargoEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.vessel = JsonUtils.pullString(jsonEvent, "Vessel");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.inventory = GameFilesUtils.createCargoInventory(JsonUtils.pullJsonArray(jsonEvent, "Inventory"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getVessel() {
		return vessel;
	}

	public List<CargoInventory> getInventory() {
		return inventory;
	}
	
	public Integer getCount() {
		return count;
	}

}
