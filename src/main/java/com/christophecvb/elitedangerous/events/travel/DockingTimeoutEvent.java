package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class DockingTimeoutEvent extends Event {
    public String stationName;
    public String stationType;
    public Long marketID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDockingRequestedEventTriggered((DockingTimeoutEvent) event);
        }

        void onDockingRequestedEventTriggered(DockingTimeoutEvent dockingRequestedEvent);
    }
}
