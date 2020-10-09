/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:50
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardSellEvent extends Event {
	
	private String shipType, shipTypeLocalised;
	private Integer sellShipId;
	private Long shipPrice, marketId;
	
	public ShipyardSellEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.shipType = JsonUtils.pullString(jsonEvent, "ShipType");
        this.shipTypeLocalised = JsonUtils.pullString(jsonEvent, "ShipType_Localised");
        this.sellShipId = JsonUtils.pullInt(jsonEvent, "SellShipID");
        this.shipPrice = JsonUtils.pullLong(jsonEvent, "ShipPrice");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShipType() {
		return shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public Integer getSellShipId() {
		return sellShipId;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

}
