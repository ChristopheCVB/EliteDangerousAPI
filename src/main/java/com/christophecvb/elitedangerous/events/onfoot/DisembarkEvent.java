package com.christophecvb.elitedangerous.events.onfoot;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class DisembarkEvent extends Event {
    @SerializedName("SRV")
    public Boolean srv;
    public Boolean taxi;
    public Boolean multicrew;
    @SerializedName("ID")
    public Long id;
    public String starSystem;
    public Long systemAddress;
    public String body;
    public Long bodyID;
    public Boolean onStation;
    public Boolean onPlanet;
    public String stationName;
    public String stationType;
    public Long marketID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStatusEventTriggered((DisembarkEvent) event);
        }

        void onStatusEventTriggered(DisembarkEvent statusEvent);
    }
}
