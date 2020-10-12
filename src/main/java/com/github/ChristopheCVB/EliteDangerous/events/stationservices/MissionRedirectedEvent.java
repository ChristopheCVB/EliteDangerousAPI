package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionRedirectedEvent extends Event {
    public String name;
    public String newDestinationStation;
    public String newDestinationSystem;
    public String oldDestinationStation;
    public String oldDestinationSystem;
    public Long missionID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMissionRedirectedEventTriggered((MissionRedirectedEvent) event);
        }

        void onMissionRedirectedEventTriggered(MissionRedirectedEvent missionRedirectedEvent);
    }
}
