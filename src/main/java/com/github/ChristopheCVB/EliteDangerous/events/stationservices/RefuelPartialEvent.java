package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class RefuelPartialEvent extends Event {
    // TODO: Parse RefuelPartialEvent Data
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onRefuelPartialEventTriggered((RefuelPartialEvent) event);
        }

        void onRefuelPartialEventTriggered(RefuelPartialEvent refuelPartialEvent);
    }
}
