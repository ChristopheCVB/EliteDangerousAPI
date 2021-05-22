package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class USSDropEvent extends Event {
    @SerializedName("USSType")
    public String ussType;
    @SerializedName("USSType_Localised")
    public String ussTypeLocalised;
    @SerializedName("USSThreat")
    public Integer ussThreat;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onUSSDropEventTriggered((USSDropEvent) event);
        }

        void onUSSDropEventTriggered(USSDropEvent ussDropEvent);
    }
}
