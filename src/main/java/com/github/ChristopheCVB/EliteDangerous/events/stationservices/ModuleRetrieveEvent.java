/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:20
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleRetrieveEvent extends Event {
	
	private Long marketId;
	private String slot, retrievedItem, retrievedItemLocalised, ship, swapOutItem, swapOutItemLocalised;
	private Integer shipId;
	private Boolean hot;
	
	public ModuleRetrieveEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.slot = JsonUtils.pullString(jsonEvent, "Slot");
        this.retrievedItem = JsonUtils.pullString(jsonEvent, "RetrievedItem");
        this.retrievedItemLocalised = JsonUtils.pullString(jsonEvent, "RetrievedItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.swapOutItem = JsonUtils.pullString(jsonEvent, "SwapOutItem");
        this.swapOutItemLocalised = JsonUtils.pullString(jsonEvent, "SwapOutItem_Localised");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.hot = JsonUtils.pullBoolean(jsonEvent, "Hot");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketId() {
		return marketId;
	}

	public String getSlot() {
		return slot;
	}

	public String getRetrievedItem() {
		return retrievedItem;
	}

	public String getRetrievedItemLocalised() {
		return retrievedItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public String getSwapOutItem() {
		return swapOutItem;
	}

	public String getSwapOutItemLocalised() {
		return swapOutItemLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getHot() {
		return hot;
	}

}
