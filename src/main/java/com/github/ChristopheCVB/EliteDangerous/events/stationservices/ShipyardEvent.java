package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardEvent extends Event {
    public Long marketID;
    public String stationName, starSystem;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipyardEventTriggered((ShipyardEvent) event);
        }

        void onShipyardEventTriggered(ShipyardEvent shipyardEvent);
    }
    // TODO: loadFromFile Shipyard.json
}
