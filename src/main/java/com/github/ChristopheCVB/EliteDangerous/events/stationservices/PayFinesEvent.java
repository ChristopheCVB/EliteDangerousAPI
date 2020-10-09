/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:52
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class PayFinesEvent extends Event {
	
	private Long amount;
	private Integer shipId;
	private Boolean allFines;

	public PayFinesEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.amount = JsonUtils.pullLong(jsonEvent, "Amount");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.allFines = JsonUtils.pullBoolean(jsonEvent, "AllFines");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getAmount() {
		return amount;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Boolean getAllFines() {
		return allFines;
	}

}
