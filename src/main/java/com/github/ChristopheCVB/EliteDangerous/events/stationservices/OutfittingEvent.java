package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class OutfittingEvent extends Event {
	public Long marketID;
	public String stationName, starSystem;
	
	public OutfittingEvent(String timestamp) {
        super(timestamp);
    }
}
