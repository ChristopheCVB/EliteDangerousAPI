package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class HeatDamageEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onHeatDamageEventTriggered((HeatDamageEvent) event);
        }

        void onHeatDamageEventTriggered(HeatDamageEvent heatDamageEvent);
    }
}
