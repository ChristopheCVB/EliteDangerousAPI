package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

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
