package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierFinanceEvent extends Event {
    public Double taxRate, reservePercent;
    public Long carrierID, carrierBalance, reserveBalance, availableBalance;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierFinanceEventTriggered((CarrierFinanceEvent) event);
        }

        void onCarrierFinanceEventTriggered(CarrierFinanceEvent carrierFinanceEvent);
    }
}
