package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.market.Market;

public class MarketEvent extends Event {
	public String stationName;
	public String starSystem;
	public String stationType;
	public String carrierDockingAccess;
	public Integer marketID;
	public transient Market market = Market.load();
}
