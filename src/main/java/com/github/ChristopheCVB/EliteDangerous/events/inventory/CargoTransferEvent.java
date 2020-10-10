package com.github.ChristopheCVB.EliteDangerous.events.inventory;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory.Transfer;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class CargoTransferEvent extends Event {
	
	private List<Transfer> transfers;
	
	public CargoTransferEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.transfers = GameFilesUtils.createTransferList(JsonUtils.pullJsonArray(jsonEvent, "Transfers"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<Transfer> getTransfers() {
		return transfers;
	}
	
}
