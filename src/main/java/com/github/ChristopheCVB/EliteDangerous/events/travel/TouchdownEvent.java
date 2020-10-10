package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class TouchdownEvent extends Event {
	public Boolean playerControlled;
	public Double latitude, longitude;
	
	public TouchdownEvent(String timestamp) {
        super(timestamp);
    }
}
