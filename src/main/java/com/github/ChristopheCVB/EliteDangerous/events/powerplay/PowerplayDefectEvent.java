package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayDefectEvent extends Event {
    public String fromPower;
    public String toPower;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayDefectEventTriggered((PowerplayDefectEvent) event);
        }

        void onPowerplayDefectEventTriggered(PowerplayDefectEvent powerplayDefectEvent);
    }
}
