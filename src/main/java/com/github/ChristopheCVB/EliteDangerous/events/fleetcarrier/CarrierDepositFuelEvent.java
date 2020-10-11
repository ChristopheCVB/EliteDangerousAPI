package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierDepositFuelEvent extends Event {
	public Integer total, amount;
	public Long carrierID;
}
