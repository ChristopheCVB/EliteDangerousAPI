package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class RestockVehicleEvent extends Event {
    public String type, loadout;
    public Long cost;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onRestockVehicleEventTriggered((RestockVehicleEvent) event);
        }

        void onRestockVehicleEventTriggered(RestockVehicleEvent restockVehicleEvent);
    }
}
