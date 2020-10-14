package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierModulePackEvent extends CarrierPackEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierModulePackEventTriggered((CarrierModulePackEvent) event);
        }

        void onCarrierModulePackEventTriggered(CarrierModulePackEvent carrierModulePackEvent);
    }
}
