/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:34
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleStoreEvent extends Event {
	
	private String slot, storedItem, storedItemLocalised, ship;
	private Integer shipId;
	private Boolean hot;
	private Long marketId;
	
	public ModuleStoreEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.slot = JsonUtils.pullString(jsonEvent, "Slot");
        this.storedItem = JsonUtils.pullString(jsonEvent, "StoredItem");
        this.storedItemLocalised = JsonUtils.pullString(jsonEvent, "StoredItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.hot = JsonUtils.pullBoolean(jsonEvent, "Hot");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSlot() {
		return slot;
	}

	public String getStoredItem() {
		return storedItem;
	}

	public String getStoredItemLocalised() {
		return storedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getHot() {
		return hot;
	}

	public Long getMarketId() {
		return marketId;
	}

}
