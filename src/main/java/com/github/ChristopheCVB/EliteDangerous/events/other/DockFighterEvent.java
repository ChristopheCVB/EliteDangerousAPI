package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DockFighterEvent extends DockEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDockFighterEventTriggered((DockFighterEvent) event);
        }

        void onDockFighterEventTriggered(DockFighterEvent dockFighterEvent);
    }
}
