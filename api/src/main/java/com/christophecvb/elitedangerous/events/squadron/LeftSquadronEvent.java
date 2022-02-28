package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class LeftSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLeftSquadronEventTriggered((LeftSquadronEvent) event);
        }

        void onLeftSquadronEventTriggered(LeftSquadronEvent leftSquadronEvent);
    }
}
