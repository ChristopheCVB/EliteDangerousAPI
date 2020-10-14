package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class QuitACrewEvent extends Event {
    public String captain;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onQuitACrewEventTriggered((QuitACrewEvent) event);
        }

        void onQuitACrewEventTriggered(QuitACrewEvent quitACrewEvent);
    }
}
