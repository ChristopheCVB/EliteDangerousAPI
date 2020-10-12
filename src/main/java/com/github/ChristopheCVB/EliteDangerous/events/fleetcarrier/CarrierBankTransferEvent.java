package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierBankTransferEvent extends Event {
    public Long deposit, carrierID, playerBalance, carrierBalance;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierBankTransferEventTriggered((CarrierBankTransferEvent) event);
        }

        void onCarrierBankTransferEventTriggered(CarrierBankTransferEvent carrierBankTransferEvent);
    }
}
