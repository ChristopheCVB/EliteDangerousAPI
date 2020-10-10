package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SellDronesEvent extends Event {
	public String type;
	public Integer count;
	public Long sellPrice, totalSale;
	
	public SellDronesEvent(String timestamp) {
        super(timestamp);
    }
}
