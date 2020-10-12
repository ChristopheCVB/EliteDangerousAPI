package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class HeatDamageEvent extends Event {
    @SerializedName("ID")
    public String id;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onHeatDamageEventTriggered((HeatDamageEvent) event);
        }

        void onHeatDamageEventTriggered(HeatDamageEvent heatDamageEvent);
    }
}
