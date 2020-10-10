package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class RestockVehicleEvent extends Event {
	public String type, loadout;
	public Long cost;
	public Integer count;
	
	public RestockVehicleEvent(String timestamp) {
        super(timestamp);
    }
}
