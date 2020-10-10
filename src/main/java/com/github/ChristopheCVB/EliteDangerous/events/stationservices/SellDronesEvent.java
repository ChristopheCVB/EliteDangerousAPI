package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SellDronesEvent extends Event {
	
	private String type;
	private Integer count;
	private Long sellPrice, totalSale;
	
	public SellDronesEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.sellPrice = JsonUtils.pullLong(jsonEvent, "SellPrice");
        this.totalSale = JsonUtils.pullLong(jsonEvent, "TotalSale");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public Integer getCount() {
		return count;
	}

	public Long getSellPrice() {
		return sellPrice;
	}

	public Long getTotalSale() {
		return totalSale;
	}

}
