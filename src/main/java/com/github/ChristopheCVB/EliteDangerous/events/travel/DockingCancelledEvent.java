package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DockingCancelledEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDockingCancelledEventTriggered((DockingCancelledEvent) event);
        }

        void onDockingCancelledEventTriggered(DockingCancelledEvent dockingCancelledEvent);
    }
}
