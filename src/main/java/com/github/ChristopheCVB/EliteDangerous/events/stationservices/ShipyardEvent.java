package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardEvent extends Event {
	public Long marketID;
	public String stationName, starSystem;
	
	public ShipyardEvent(String timestamp) {
        super(timestamp);
    }
}
