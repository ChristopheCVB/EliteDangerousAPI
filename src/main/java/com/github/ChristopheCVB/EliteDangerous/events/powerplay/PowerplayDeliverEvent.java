package com.github.ChristopheCVB.EliteDangerous.events.powerplay;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayDeliverEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayDeliverEventTriggered((PowerplayDeliverEvent) event);
        }

        void onPowerplayDeliverEventTriggered(PowerplayDeliverEvent powerplayDeliverEvent);
    }
}
