package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class MarketBuyEvent extends Event {
	
	public Long marketID;
	public String type;
	@SerializedName("Type_Localised")
	public String typeLocalised;
	public Integer count;
	public Integer buyPrice;
	public Integer totalCost;
	
	public MarketBuyEvent(String timestamp) {
        super(timestamp);
    }
}
