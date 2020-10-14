package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class LaunchFighterEvent extends Event {
    public String loadout;
    @SerializedName("ID")
    public Long id;
    public Boolean playerControlled;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLaunchFighterEventTriggered((LaunchFighterEvent) event);
        }

        void onLaunchFighterEventTriggered(LaunchFighterEvent launchFighterEvent);
    }
}
