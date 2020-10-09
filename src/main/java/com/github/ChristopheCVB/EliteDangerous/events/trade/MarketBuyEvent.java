package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MarketBuyEvent extends Event {
	
	private Long marketID;
	private String type, typeLocalised;
	private Integer count, buyPrice, totalCost;
	
	public MarketBuyEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.typeLocalised = JsonUtils.pullString(jsonEvent, "Type_Localised");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.buyPrice = JsonUtils.pullInt(jsonEvent, "BuyPrice");
        this.totalCost = JsonUtils.pullInt(jsonEvent, "TotalCost");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketID() {
		return marketID;
	}

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
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

}
