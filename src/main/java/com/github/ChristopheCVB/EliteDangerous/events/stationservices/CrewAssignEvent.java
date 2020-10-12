package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewAssignEvent extends Event {
    public String name;
    public String role;
    public Integer crewID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewAssignEventTriggered((CrewAssignEvent) event);
        }

        void onCrewAssignEventTriggered(CrewAssignEvent crewAssignEvent);
    }
}
