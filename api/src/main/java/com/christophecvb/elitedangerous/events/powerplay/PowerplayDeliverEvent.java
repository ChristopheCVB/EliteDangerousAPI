package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

public class PowerplayDeliverEvent extends PowerplayDistributionEvent {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPowerplayDeliverEventTriggered((PowerplayDeliverEvent) event);
        }

        void onPowerplayDeliverEventTriggered(PowerplayDeliverEvent powerplayDeliverEvent);
    }
}
