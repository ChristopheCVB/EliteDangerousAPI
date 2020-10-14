package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SquadronDemotionEvent extends SquadronXmotionEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSquadronDemotionEventTriggered((SquadronDemotionEvent) event);
        }

        void onSquadronDemotionEventTriggered(SquadronDemotionEvent squadronDemotionEvent);
    }
}
