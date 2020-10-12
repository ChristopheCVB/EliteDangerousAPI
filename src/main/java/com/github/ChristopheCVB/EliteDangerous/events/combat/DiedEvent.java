package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class DiedEvent extends Event {
    // TODO: This interface is useless
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDiedEventTriggered((DiedEvent) event);
        }

        void onDiedEventTriggered(DiedEvent diedEvent);
    }
}
