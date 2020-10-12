package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class ClearSavedGameEvent extends Event {
    public String name;
    @SerializedName("FID")
    public String fid;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onClearSavedGameEventTriggered((ClearSavedGameEvent) event);
        }

        void onClearSavedGameEventTriggered(ClearSavedGameEvent clearSavedGameEvent);
    }
}
