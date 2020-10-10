package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SellExplorationDataEvent extends Event {
	public String[] systems, discovered;
	public Integer baseValue, bonus, totalEarnings;
	
	public SellExplorationDataEvent(String timestamp) {
        super(timestamp);
    }
}
