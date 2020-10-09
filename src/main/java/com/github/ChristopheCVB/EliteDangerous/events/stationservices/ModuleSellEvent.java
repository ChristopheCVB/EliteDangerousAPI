/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:26
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleSellEvent extends Event {
	
	private String slot, sellItem, sellItemLocalised, ship;
	private Long sellPrice, marketId;
	private Integer shipId;
	
	public ModuleSellEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.slot = JsonUtils.pullString(jsonEvent, "Slot");
        this.sellItem = JsonUtils.pullString(jsonEvent, "SellItem");
        this.sellItemLocalised = JsonUtils.pullString(jsonEvent, "SellItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.sellPrice = JsonUtils.pullLong(jsonEvent, "SellPrice");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSlot() {
		return slot;
	}

	public String getSellItem() {
		return sellItem;
	}

	public String getSellItemLocalised() {
		return sellItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Integer getShipId() {
		return shipId;
	}

}
