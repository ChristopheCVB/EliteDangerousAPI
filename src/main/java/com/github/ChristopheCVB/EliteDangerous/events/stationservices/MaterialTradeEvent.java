/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:23
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.TradeData;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MaterialTradeEvent extends Event {
	
	Long marketId;
	String traderType;
	TradeData paid, received;

	public MaterialTradeEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.traderType = JsonUtils.pullString(jsonEvent, "TraderType");
        this.paid = GameFilesUtils.createTradeData(JsonUtils.pullJsonObject(jsonEvent, "Paid"));
        this.received = GameFilesUtils.createTradeData(JsonUtils.pullJsonObject(jsonEvent, "Received"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketId() {
		return marketId;
	}

	public String getTraderType() {
		return traderType;
	}

	public TradeData getPaid() {
		return paid;
	}

	public TradeData getReceived() {
		return received;
	}

}
