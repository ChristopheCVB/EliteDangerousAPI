package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;
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
