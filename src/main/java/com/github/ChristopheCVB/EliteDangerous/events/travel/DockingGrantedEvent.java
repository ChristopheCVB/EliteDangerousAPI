package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DockingGrantedEvent extends Event {
	
	public String stationName;
	public String stationType;
	public Long marketID;
	public Integer landingPad;
	
	public DockingGrantedEvent(String timestamp) {
        super(timestamp);
    }
}
