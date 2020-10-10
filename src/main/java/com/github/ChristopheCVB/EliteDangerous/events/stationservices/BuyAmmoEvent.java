package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyAmmoEvent extends Event {
	
	public Integer cost;

	public BuyAmmoEvent(String timestamp) {
        super(timestamp);
    }
}
