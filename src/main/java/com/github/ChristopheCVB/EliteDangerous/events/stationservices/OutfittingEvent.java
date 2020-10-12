package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class OutfittingEvent extends Event {
    public Long marketID;
    public String stationName, starSystem;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onOutfittingEventTriggered((OutfittingEvent) event);
        }

        void onOutfittingEventTriggered(OutfittingEvent outfittingEvent);
    }
    // TODO: loadFromFile Outfitting.json
}
