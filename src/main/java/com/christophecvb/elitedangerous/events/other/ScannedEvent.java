package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class ScannedEvent extends Event {
    public String scanType;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onScannedEventTriggered((ScannedEvent) event);
        }

        void onScannedEventTriggered(ScannedEvent scannedEvent);
    }
}
