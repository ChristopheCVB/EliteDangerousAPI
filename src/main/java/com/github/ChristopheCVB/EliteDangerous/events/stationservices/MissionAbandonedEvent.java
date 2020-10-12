package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionAbandonedEvent extends Event {
    public String name;
    public Long missionID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMissionAbandonedEventTriggered((MissionAbandonedEvent) event);
        }

        void onMissionAbandonedEventTriggered(MissionAbandonedEvent missionAbandonedEvent);
    }
}
