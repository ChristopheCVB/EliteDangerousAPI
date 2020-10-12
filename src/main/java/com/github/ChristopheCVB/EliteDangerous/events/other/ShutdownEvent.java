package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShutdownEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShutdownEventTriggered((ShutdownEvent) event);
        }

        void onShutdownEventTriggered(ShutdownEvent shutdownEvent);
    }
}
