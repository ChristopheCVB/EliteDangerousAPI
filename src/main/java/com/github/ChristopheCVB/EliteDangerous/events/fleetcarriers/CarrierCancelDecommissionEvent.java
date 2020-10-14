package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierCancelDecommissionEvent extends Event {
    public Long carrierID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierCancelDecommissionEventTriggered((CarrierCancelDecommissionEvent) event);
        }

        void onCarrierCancelDecommissionEventTriggered(CarrierCancelDecommissionEvent CarrierCancelDecommissionEvent);
    }
}
