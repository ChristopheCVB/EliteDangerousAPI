/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:17
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardBuyEvent extends Event {
	
	private String shipType, sellOldShip;
	private Long shipPrice, sellPrice;
	private Integer sellShipId;
	
	public ShipyardBuyEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.shipType = JsonUtils.pullString(jsonEvent, "ShipType");
        this.sellOldShip = JsonUtils.pullString(jsonEvent, "SellOldShip");
        this.shipPrice = JsonUtils.pullLong(jsonEvent, "ShipPrice");
        this.sellPrice = JsonUtils.pullLong(jsonEvent, "SellPrice");
        this.sellShipId = JsonUtils.pullInt(jsonEvent, "SellShipID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShipType() {
		return shipType;
	}

	public String getSellOldShip() {
		return sellOldShip;
	}

	public Long getShipPrice() {
		return shipPrice;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Integer getSellShipId() {
		return sellShipId;
	}

}
