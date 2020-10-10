package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierBankTransferEvent extends Event {
	
	public Long deposit;
	public Long carrierId;
	public Long playerBalance;
	public Long carrierBalance;

	public CarrierBankTransferEvent(String timestamp) {
        super(timestamp);
    }
}
