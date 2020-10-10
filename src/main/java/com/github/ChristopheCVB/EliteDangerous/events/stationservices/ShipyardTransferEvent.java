package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardTransferEvent extends Event {
	public String shipType, shipTypeLocalised, system;
	public Integer shipID;
	public Long shipMarketID, transferPrice, transferTime, marketID;
	public Double distance;
	
	public ShipyardTransferEvent(String timestamp) {
		super(timestamp);
    }
}
