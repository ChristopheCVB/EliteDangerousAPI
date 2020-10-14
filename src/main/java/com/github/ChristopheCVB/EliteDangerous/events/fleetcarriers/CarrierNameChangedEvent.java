package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierNameChangedEvent extends Event {
    public Long carrierID;
    public String callsign;
    public String name;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierNameChangedEventTriggered((CarrierNameChangedEvent) event);
        }

        void onCarrierNameChangedEventTriggered(CarrierNameChangedEvent carrierNameChangedEvent);
    }
}
