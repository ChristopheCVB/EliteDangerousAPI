package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MaterialDiscoveredEvent extends Event {
	private String category, name;
	private Integer count;
	
	public MaterialDiscoveredEvent(String timestamp) {
        super(timestamp);
    }
}
