package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyExplorationDataEvent extends Event {
	public String system;
	public Integer cost;
	
	public BuyExplorationDataEvent(String timestamp) {
		super(timestamp);
	}
}
