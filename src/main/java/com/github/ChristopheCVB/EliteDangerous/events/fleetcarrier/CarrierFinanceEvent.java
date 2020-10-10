package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierFinanceEvent extends Event {
	
	public Double taxRate;
	public Double reservePercent;
	public Long carrierId;
	public Long carrierBalance;
	public Long reserveBalance;
	public Long availableBalance;
	
	public CarrierFinanceEvent(String timestamp) {
        super(timestamp);
    }
}
