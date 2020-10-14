package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LaunchDroneEvent extends Event {
    public static final String[] TYPES = {"Hatchbreaker", "FuelTransfer", "Collection", "Prospector", "Repair", "Research", "Decontamination"};

    public String type;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLaunchDroneEventTriggered((LaunchDroneEvent) event);
        }

        void onLaunchDroneEventTriggered(LaunchDroneEvent kickCrewMemberEvent);
    }
}
