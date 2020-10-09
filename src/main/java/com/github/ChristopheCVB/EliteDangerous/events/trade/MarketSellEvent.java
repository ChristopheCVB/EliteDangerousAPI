package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MarketSellEvent extends Event {
	
	private Long marketID;
	private String type, typeLocalised;
	private Integer count, sellPrice, totalSale, avgPricePaid;
	private Boolean illegalGoods, stolenGoods, blackMarket;
	
	public MarketSellEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.typeLocalised = JsonUtils.pullString(jsonEvent, "Type_Localised");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.sellPrice = JsonUtils.pullInt(jsonEvent, "SellPrice");
        this.totalSale = JsonUtils.pullInt(jsonEvent, "TotalSale");
        this.avgPricePaid = JsonUtils.pullInt(jsonEvent, "AvgPricePaid");
        this.illegalGoods = JsonUtils.pullBoolean(jsonEvent, "IllegalGoods");
        this.stolenGoods = JsonUtils.pullBoolean(jsonEvent, "StolenGoods");
        this.blackMarket = JsonUtils.pullBoolean(jsonEvent, "BlackMarket");

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

	public Integer getSellPrice() {
		return sellPrice;
	}

	public Integer getTotalSale() {
		return totalSale;
	}

	public Integer getAvgPricePaid() {
		return avgPricePaid;
	}

	public Boolean getIllegalGoods() {
		return illegalGoods;
	}

	public Boolean getStolenGoods() {
		return stolenGoods;
	}

	public Boolean getBlackMarket() {
		return blackMarket;
	}

}
