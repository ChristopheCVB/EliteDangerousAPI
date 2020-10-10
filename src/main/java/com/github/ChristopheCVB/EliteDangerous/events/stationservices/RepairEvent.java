package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class RepairEvent extends Event {
	public String item;
	public Long cost;
	
	public RepairEvent(String timestamp) {
        super(timestamp);
    }
}
