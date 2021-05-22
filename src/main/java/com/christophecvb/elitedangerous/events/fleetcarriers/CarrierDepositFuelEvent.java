package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierDepositFuelEvent extends Event {
    public Integer total, amount;
    public Long carrierID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierDepositFuelEventTriggered((CarrierDepositFuelEvent) event);
        }

        void onCarrierDepositFuelEventTriggered(CarrierDepositFuelEvent carrierDepositFuelEvent);
    }
}
