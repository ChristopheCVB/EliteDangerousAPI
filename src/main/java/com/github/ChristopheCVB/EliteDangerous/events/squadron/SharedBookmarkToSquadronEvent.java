package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SharedBookmarkToSquadronEvent extends SquadronEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSharedBookmarkToSquadronEventTriggered((SharedBookmarkToSquadronEvent) event);
        }

        void onSharedBookmarkToSquadronEventTriggered(SharedBookmarkToSquadronEvent sharedBookmarkToSquadronEvent);
    }
}
