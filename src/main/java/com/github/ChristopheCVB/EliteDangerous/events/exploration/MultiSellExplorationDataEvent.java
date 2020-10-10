package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.station.Discovered;

import java.util.List;

public class MultiSellExplorationDataEvent extends Event {
	
	private List<Discovered> discovered;
	private Integer baseValue, totalEarnings, bonus;
	
	public MultiSellExplorationDataEvent(String timestamp) {
        super(timestamp);
    }
}
