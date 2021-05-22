package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class InvitedToSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onInvitedToSquadronEventTriggered((InvitedToSquadronEvent) event);
        }

        void onInvitedToSquadronEventTriggered(InvitedToSquadronEvent invitedToSquadronEvent);
    }
}
