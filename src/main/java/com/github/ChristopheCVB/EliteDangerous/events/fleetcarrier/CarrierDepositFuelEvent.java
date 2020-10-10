package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierDepositFuelEvent extends Event {
	
	public Integer total;
	public Integer amount;
	public Long carrierId;
	
	public CarrierDepositFuelEvent(String timestamp) {
        super(timestamp);
    }
}
