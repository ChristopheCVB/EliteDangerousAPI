package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class LaunchSRVEvent extends Event {
    public String loadout;
    @SerializedName("ID")
    public Long id;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLaunchSRVEventTriggered((LaunchSRVEvent) event);
        }

        void onLaunchSRVEventTriggered(LaunchSRVEvent launchSRVEvent);
    }
}
