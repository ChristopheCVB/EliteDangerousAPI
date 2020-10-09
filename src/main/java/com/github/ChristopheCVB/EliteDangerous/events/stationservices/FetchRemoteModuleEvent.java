package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class FetchRemoteModuleEvent extends Event {
	
	private Integer storageSlots, serverId, transferCost, transferTime, shipId;
	private String storedItem, storedItemLocalised, ship;
	
	public FetchRemoteModuleEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.storageSlots = JsonUtils.pullInt(jsonEvent, "StorageSlot");
        this.serverId = JsonUtils.pullInt(jsonEvent, "ServerId");
        this.transferCost = JsonUtils.pullInt(jsonEvent, "TransferCost");
        this.transferTime = JsonUtils.pullInt(jsonEvent, "TransferTime");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.storedItem = JsonUtils.pullString(jsonEvent, "StoredItem");
        this.storedItemLocalised = JsonUtils.pullString(jsonEvent, "StoredItem_Localised");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getStorageSlots() {
		return storageSlots;
	}
	
	public Integer getServerId() {
		return serverId;
	}

	public Integer getTransferCost() {
		return transferCost;
	}

	public Integer getTransferTime() {
		return transferTime;
	}

	public Integer getShipId() {
		return shipId;
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


}
