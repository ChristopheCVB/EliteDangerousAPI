/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/10/2020 10:43
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.ModuleItem;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class MassModuleStoreEvent extends Event {
	
	public Long marketID;
	public String ship;
	public Integer shipId;
	public List<ModuleItem> items;

	public MassModuleStoreEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.items = GameFilesUtils.createModuleItemsList(JsonUtils.pullJsonArray(jsonEvent, "Items"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketID() {
		return marketID;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public List<ModuleItem> getItems() {
		return items;
	}

}
