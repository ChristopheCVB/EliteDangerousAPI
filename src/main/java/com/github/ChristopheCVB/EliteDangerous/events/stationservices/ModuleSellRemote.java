/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:29
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ModuleSellRemote extends Event {
	
	private Integer storageSlot, shipId;
	private String sellItem, sellItemLocalised, ship;
	private Long serverId, sellPrice;
	
	public ModuleSellRemote(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.storageSlot = JsonUtils.pullInt(jsonEvent, "StorageSlot");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.sellItem = JsonUtils.pullString(jsonEvent, "SellItem");
        this.sellItemLocalised = JsonUtils.pullString(jsonEvent, "SellItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.serverId = JsonUtils.pullLong(jsonEvent, "ServerId");
        this.sellPrice = JsonUtils.pullLong(jsonEvent, "SellPrice");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getStorageSlot() {
		return storageSlot;
	}

	public Integer getShipId() {
		return shipId;
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

	public Long getServerId() {
		return serverId;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

}
