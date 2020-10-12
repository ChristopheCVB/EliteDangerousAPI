package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierJumpCancelledEvent extends Event {
    public Long carrierID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierJumpCancelledEventTriggered((CarrierJumpCancelledEvent) event);
        }

        void onCarrierJumpCancelledEventTriggered(CarrierJumpCancelledEvent carrierJumpCancelledEvent);
    }
}
