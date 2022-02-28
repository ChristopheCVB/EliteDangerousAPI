package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class MissionFailedEvent extends Event {
    public String name;
    public Long missionID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMissionFailedEventTriggered((MissionFailedEvent) event);
        }

        void onMissionFailedEventTriggered(MissionFailedEvent missionFailedEvent);
    }
}
