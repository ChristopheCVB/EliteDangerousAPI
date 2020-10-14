package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayJoinEvent extends Event {
    public String power;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayJoinEventTriggered((PowerplayJoinEvent) event);
        }

        void onPowerplayJoinEventTriggered(PowerplayJoinEvent powerplayJoinEvent);
    }
}
