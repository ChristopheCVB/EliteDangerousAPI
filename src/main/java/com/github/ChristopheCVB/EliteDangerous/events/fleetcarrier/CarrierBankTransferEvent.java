package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierBankTransferEvent extends Event {
	public Long deposit, carrierID, playerBalance, carrierBalance;

	public CarrierBankTransferEvent(String timestamp) {
        super(timestamp);
    }
}
