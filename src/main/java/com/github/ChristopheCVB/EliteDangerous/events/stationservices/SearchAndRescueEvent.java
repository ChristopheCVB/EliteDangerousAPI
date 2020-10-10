package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SearchAndRescueEvent extends Event {
	public Long marketID, reward;
	public String name, nameLocalised;
	public Integer count;
	
	public SearchAndRescueEvent(String timestamp) {
        super(timestamp);
    }
}
