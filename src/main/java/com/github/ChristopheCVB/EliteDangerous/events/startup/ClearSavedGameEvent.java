package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ClearSavedGameEvent extends Event {
    public String name;
    public String FID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onClearSavedGameEventTriggered((ClearSavedGameEvent) event);
        }

        void onClearSavedGameEventTriggered(ClearSavedGameEvent clearSavedGameEvent);
    }
}
