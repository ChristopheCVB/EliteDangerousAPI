package com.github.ChristopheCVB.EliteDangerous.events.squadron;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SquadronPromotionEvent extends SquadronXmotionEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSquadronPromotionEventTriggered((SquadronPromotionEvent) event);
        }

        void onSquadronPromotionEventTriggered(SquadronPromotionEvent squadronPromotionEvent);
    }
}
