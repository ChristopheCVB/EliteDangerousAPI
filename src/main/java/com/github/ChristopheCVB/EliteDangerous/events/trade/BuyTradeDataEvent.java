package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyTradeDataEvent extends Event {
	
	public String system;
	public Integer cost;

	public BuyTradeDataEvent(String timestamp) {
        super(timestamp);
    }
}
