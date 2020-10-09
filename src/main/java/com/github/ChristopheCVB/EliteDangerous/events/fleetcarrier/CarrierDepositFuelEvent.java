/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 07/02/2020 08:41
*/

package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CarrierDepositFuelEvent extends Event {
	
	private Integer total, amount;
	private Long carrierId;
	
	public CarrierDepositFuelEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.total = JsonUtils.pullInt(jsonEvent, "Total");
        this.amount = JsonUtils.pullInt(jsonEvent, "Amount");
        this.carrierId = JsonUtils.pullLong(jsonEvent, "CarrierID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getTotal() {
		return total;
	}

	public Integer getAmount() {
		return amount;
	}

	public Long getCarrierId() {
		return carrierId;
	}

}
