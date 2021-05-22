package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierShipPackEvent extends CarrierPackEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierShipPackEventTriggered((CarrierShipPackEvent) event);
        }

        void onCarrierShipPackEventTriggered(CarrierShipPackEvent carrierShipPackEvent);
    }
}
