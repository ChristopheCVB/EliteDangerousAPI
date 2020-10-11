package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardSwapEvent extends Event {
	public String shipType, shipTypeLocalised, storeOldShip;
	public Integer shipID, storeShipID;
	public Long marketID;
}
