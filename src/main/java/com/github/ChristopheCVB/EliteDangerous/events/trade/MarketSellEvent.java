package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class MarketSellEvent extends Event {
	
	public Long marketID;
	public String type;
	@SerializedName("Type_Localised")
	public String typeLocalised;
	public Integer count;
	public Integer sellPrice;
	public Integer totalSale;
	public Integer avgPricePaid;
	public Boolean illegalGoods;
	public Boolean stolenGoods;
	public Boolean blackMarket;
	
	public MarketSellEvent(String timestamp) {
		super(timestamp);
    }
}
