/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 19:41
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleSwapEvent extends Event {

	private Long marketId;
	private String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
	private Integer shipId;
	
	public ModuleSwapEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.fromSlot = JsonUtils.pullString(jsonEvent, "FromSlot");
        this.toSlot = JsonUtils.pullString(jsonEvent, "ToSlot");
        this.fromItem = JsonUtils.pullString(jsonEvent, "FromItem");
        this.fromItemLocalised = JsonUtils.pullString(jsonEvent, "FromItem_Localised");
        this.toItem = JsonUtils.pullString(jsonEvent, "ToItem");
        this.toItemLocalised = JsonUtils.pullString(jsonEvent, "ToItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketId() {
		return marketId;
	}

	public String getFromSlot() {
		return fromSlot;
	}

	public String getToSlot() {
		return toSlot;
	}

	public String getFromItem() {
		return fromItem;
	}

	public String getFromItemLocalised() {
		return fromItemLocalised;
	}

	public String getToItem() {
		return toItem;
	}

	public String getToItemLocalised() {
		return toItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

}
