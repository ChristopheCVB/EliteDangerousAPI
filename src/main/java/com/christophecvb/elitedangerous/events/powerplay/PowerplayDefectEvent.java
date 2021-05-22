package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

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
