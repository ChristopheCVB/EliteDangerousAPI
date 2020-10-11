package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardSellEvent extends Event {
	public String shipType, shipTypeLocalised;
	public Integer sellShipID;
	public Long shipPrice, marketID;
}
