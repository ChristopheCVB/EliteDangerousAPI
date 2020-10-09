/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:15
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleBuyEvent extends Event {
	
	private String slot, storedItem, storedItemLocalised, buyItem, buyItemLocalised, ship, sellItem, sellItemLocalised;
	private Long buyPrice, marketId, sellPrice;
	private Integer shipId;
	
	public ModuleBuyEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
		this.sellPrice = JsonUtils.pullLong(jsonEvent, "SellPrice");
        this.sellItem = JsonUtils.pullString(jsonEvent, "SellItem");
        this.sellItemLocalised = JsonUtils.pullString(jsonEvent, "SellItem_Localised");
        this.slot = JsonUtils.pullString(jsonEvent, "Slot");
        this.storedItem = JsonUtils.pullString(jsonEvent, "StoredItem");
        this.storedItemLocalised = JsonUtils.pullString(jsonEvent, "StoredItem_Localised");
        this.buyItem = JsonUtils.pullString(jsonEvent, "BuyItem");
        this.buyItemLocalised = JsonUtils.pullString(jsonEvent, "BuyItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.buyPrice = JsonUtils.pullLong(jsonEvent, "BuyPrice");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");

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

	public String getBuyItem() {
		return buyItem;
	}

	public String getBuyItemLocalised() {
		return buyItemLocalised;
	}

	public String getShip() {
		return ship;
	}

	public String getSellItem() {
		return sellItem;
	}

	public String getSellItemLocalised() {
		return sellItemLocalised;
	}

	public Long getBuyPrice() {
		return buyPrice;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Integer getShipId() {
		return shipId;
	}

}
