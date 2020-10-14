package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayVoteEvent extends Event {
    public String power;
    public Integer votes;
    public String system;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayVoteEventTriggered((PowerplayVoteEvent) event);
        }

        void onPowerplayVoteEventTriggered(PowerplayVoteEvent powerplayVoteEvent);
    }
}
