package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class JoinedSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onJoinedSquadronEventTriggered((JoinedSquadronEvent) event);
        }

        void onJoinedSquadronEventTriggered(JoinedSquadronEvent joinedSquadronEvent);
    }
}
