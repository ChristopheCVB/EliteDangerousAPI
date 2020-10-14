package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LeftSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLeftSquadronEventTriggered((LeftSquadronEvent) event);
        }

        void onLeftSquadronEventTriggered(LeftSquadronEvent leftSquadronEvent);
    }
}
