package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class HeatWarningEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onHeatWarningEventTriggered((HeatWarningEvent) event);
        }

        void onHeatWarningEventTriggered(HeatWarningEvent heatWarningEvent);
    }
}
