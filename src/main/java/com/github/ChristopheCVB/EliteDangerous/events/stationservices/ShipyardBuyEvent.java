package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardBuyEvent extends Event {
	public String shipType, sellOldShip;
	public Long shipPrice, sellPrice;
	public Integer sellShipID;
	
	public ShipyardBuyEvent(String timestamp) {
        super(timestamp);
    }
}
