package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
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
