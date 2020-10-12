package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class HeatWarningEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onHeatWarningEventTriggered((HeatWarningEvent) event);
        }

        void onHeatWarningEventTriggered(HeatWarningEvent heatWarningEvent);
    }
}
