/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:07
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardSwapEvent extends Event {
	
	private String shipType, shipTypeLocalised, storeOldShip;
	private Integer shipId, storeShipId;
	private Long marketId;
	
	public ShipyardSwapEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.shipType = JsonUtils.pullString(jsonEvent, "ShipType");
        this.shipTypeLocalised = JsonUtils.pullString(jsonEvent, "ShipType_Localised");
        this.storeOldShip = JsonUtils.pullString(jsonEvent, "StoreOldShip");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.storeShipId = JsonUtils.pullInt(jsonEvent, "StoreShipID");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShipType() {
		return shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public String getStoreOldShip() {
		return storeOldShip;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Integer getStoreShipId() {
		return storeShipId;
	}

	public Long getMarketId() {
		return marketId;
	}

}
