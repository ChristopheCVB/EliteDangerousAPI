package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SquadronStartupEvent extends SquadronEvent {
    public Integer currentRank;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSquadronStartupEventTriggered((SquadronStartupEvent) event);
        }

        void onSquadronStartupEventTriggered(SquadronStartupEvent squadronStartupEvent);
    }
}
