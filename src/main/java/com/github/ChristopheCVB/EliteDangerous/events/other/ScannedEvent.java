package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

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
