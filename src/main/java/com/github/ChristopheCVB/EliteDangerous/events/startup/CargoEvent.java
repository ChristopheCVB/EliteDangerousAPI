package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.CargoInventory;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class CargoEvent extends Event {

	public String vessel;
	public Integer count;
	public ArrayList<CargoInventory> inventory;
	
	public CargoEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.vessel = JsonUtils.pullString(jsonEvent, "Vessel");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        //TODO: Can you do this one again? it has a createCargoInventory also the CargoInventory on line 16 is not changed yet
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
