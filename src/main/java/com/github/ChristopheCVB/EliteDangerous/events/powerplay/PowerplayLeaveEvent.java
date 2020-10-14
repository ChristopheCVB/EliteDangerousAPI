package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayLeaveEvent extends Event {
    public String power;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayLeaveEventTriggered((PowerplayLeaveEvent) event);
        }

        void onPowerplayLeaveEventTriggered(PowerplayLeaveEvent powerplayLeaveEvent);
    }
}
