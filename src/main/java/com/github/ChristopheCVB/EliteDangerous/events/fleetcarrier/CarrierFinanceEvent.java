package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierFinanceEvent extends Event {
	public Double taxRate, reservePercent;
	public Long carrierID, carrierBalance, reserveBalance, availableBalance;
}
