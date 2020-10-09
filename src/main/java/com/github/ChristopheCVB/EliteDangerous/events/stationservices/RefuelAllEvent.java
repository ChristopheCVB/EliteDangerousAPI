/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:41
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class RefuelAllEvent extends Event {
	
	private Long cost;
	private Double amount;
	
	public RefuelAllEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.cost = JsonUtils.pullLong(jsonEvent, "Cost");
        this.amount = JsonUtils.pullDouble(jsonEvent, "Amount");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getCost() {
		return cost;
	}

	public Double getAmount() {
		return amount;
	}

}
