package com.christophecvb.elitedangerous.events.onfoot;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class DropShipDeployEvent extends Event {
    public String starSystem;
    public Long systemAddress;
    public String body;
    public Long bodyID;
    public Boolean onStation;
    public Boolean onPlanet;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStatusEventTriggered((DropShipDeployEvent) event);
        }

        void onStatusEventTriggered(DropShipDeployEvent statusEvent);
    }
}
