package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class AppliedToSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onAppliedToSquadronEventTriggered((AppliedToSquadronEvent) event);
        }

        void onAppliedToSquadronEventTriggered(AppliedToSquadronEvent appliedToSquadronEvent);
    }
}
