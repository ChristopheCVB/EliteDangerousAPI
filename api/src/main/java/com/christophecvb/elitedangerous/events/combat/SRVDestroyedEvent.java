package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class SRVDestroyedEvent extends Event {
    @SerializedName("ID")
    public String id;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSRVDestroyedEventTriggered((SRVDestroyedEvent) event);
        }

        void onSRVDestroyedEventTriggered(SRVDestroyedEvent srvDestroyedEvent);
    }
}
