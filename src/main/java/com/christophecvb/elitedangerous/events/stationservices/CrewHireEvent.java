package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class CrewHireEvent extends Event {
    public String name;
    public String faction;
    public Integer crewID;
    public Integer cost;
    public Integer combatRank;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewHireEventTriggered((CrewHireEvent) event);
        }

        void onCrewHireEventTriggered(CrewHireEvent crewHireEvent);
    }
}
