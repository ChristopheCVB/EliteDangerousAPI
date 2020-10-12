package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SRVDestroyedEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSRVDestroyedEventTriggered((SRVDestroyedEvent) event);
        }

        void onSRVDestroyedEventTriggered(SRVDestroyedEvent srvDestroyedEvent);
    }
}
