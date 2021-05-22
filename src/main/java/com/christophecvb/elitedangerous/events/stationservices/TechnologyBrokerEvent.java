package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class TechnologyBrokerEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onTechnologyBrokerEventTriggered((TechnologyBrokerEvent) event);
        }

        void onTechnologyBrokerEventTriggered(TechnologyBrokerEvent technologyBrokerEvent);
    }
}
