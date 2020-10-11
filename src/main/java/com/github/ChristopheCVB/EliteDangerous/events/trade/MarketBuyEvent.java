package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MarketBuyEvent extends Event {
	public Long marketID;
	public String type;
	public String typeLocalised;
	public Integer count;
	public Integer buyPrice;
	public Integer totalCost;
}
