package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class DiscoveryScanEvent extends Event {
    public Long systemAddress;
    public Integer bodies;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDiscoveryScanEventTriggered((DiscoveryScanEvent) event);
        }

        void onDiscoveryScanEventTriggered(DiscoveryScanEvent discoveryScanEvent);
    }
}
