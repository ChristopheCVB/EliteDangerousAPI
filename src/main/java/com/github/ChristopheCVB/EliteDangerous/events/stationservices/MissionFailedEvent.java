package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

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
