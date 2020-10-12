package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayEvent extends Event {
    public String power;
    public Integer rank;
    public Integer merits;
    public Integer votes;
    public Integer timePledged;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayEventTriggered((PowerplayEvent) event);
        }

        void onPowerplayEventTriggered(PowerplayEvent powerplayEvent);
    }
}
