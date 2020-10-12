package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class TechnologyBrokerEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onTechnologyBrokerEventTriggered((TechnologyBrokerEvent) event);
        }

        void onTechnologyBrokerEventTriggered(TechnologyBrokerEvent technologyBrokerEvent);
    }
}
