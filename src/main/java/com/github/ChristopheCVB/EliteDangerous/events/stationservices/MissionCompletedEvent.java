package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MissionCompletedEvent extends Event {
    public String faction;
    public String name;
    public String targetFaction;
    public String destinationSystem;
    public String destinationStation;
    public Long missionID;
    public Long reward;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMissionCompletedEventTriggered((MissionCompletedEvent) event);
        }

        void onMissionCompletedEventTriggered(MissionCompletedEvent missionCompletedEvent);
    }
}
