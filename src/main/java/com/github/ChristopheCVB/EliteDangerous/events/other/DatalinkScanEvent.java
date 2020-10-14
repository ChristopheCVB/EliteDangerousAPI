package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DatalinkScanEvent extends Event {
    public String message;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDatalinkScanEventTriggered((DatalinkScanEvent) event);
        }

        void onDatalinkScanEventTriggered(DatalinkScanEvent datalinkScanEvent);
    }
}
