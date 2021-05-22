package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class InterdictedEvent extends Event {
    public Boolean submitted, isPlayer;
    public String interdictor, faction, power;
    public Integer combatRank;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onInterdictedEventTriggered((InterdictedEvent) event);
        }

        void onInterdictedEventTriggered(InterdictedEvent interdictedEvent);
    }
}
