package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayCollectEvent extends Event{
    public String power;
    public String type;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayCollectEventTriggered((PowerplayCollectEvent) event);
        }

        void onPowerplayCollectEventTriggered(PowerplayCollectEvent powerplayCollectEvent);
    }
}
