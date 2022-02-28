package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class NewCommanderEvent extends Event {
    public String name;
    @SerializedName("FID")
    public String fid;
    @SerializedName("Package")
    public String starterPackage;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNewCommanderEventTriggered((NewCommanderEvent) event);
        }

        void onNewCommanderEventTriggered(NewCommanderEvent newCommanderEvent);
    }
}
