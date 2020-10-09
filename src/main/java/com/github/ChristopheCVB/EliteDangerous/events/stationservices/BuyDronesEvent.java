package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class BuyDronesEvent extends Event {
	
	private Integer count, buyPrice, totalCost;
	private String type;
	
	public BuyDronesEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.buyPrice = JsonUtils.pullInt(jsonEvent, "BuyPrice");
        this.totalCost = JsonUtils.pullInt(jsonEvent, "TotalCost");
        this.type = JsonUtils.pullString(jsonEvent, "Type");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Integer getCount() {
		return count;
	}

	public Integer getBuyPrice() {
		return buyPrice;
	}

	public Integer getTotalCost() {
		return totalCost;
	}

	public String getType() {
		return type;
	}

}
