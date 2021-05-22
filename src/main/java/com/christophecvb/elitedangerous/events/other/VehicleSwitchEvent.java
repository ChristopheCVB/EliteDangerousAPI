package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class VehicleSwitchEvent extends Event {
    public static final String[] TOS = {"Mothership", "Fighter"};

    public String to;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onVehicleSwitchEventTriggered((VehicleSwitchEvent) event);
        }

        void onVehicleSwitchEventTriggered(VehicleSwitchEvent vehicleSwitchEvent);
    }
}
