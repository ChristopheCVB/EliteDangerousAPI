package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FighterDestroyedEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFighterDestroyedEventTriggered((FighterDestroyedEvent) event);
        }

        void onFighterDestroyedEventTriggered(FighterDestroyedEvent fighterDestroyedEvent);
    }
}
