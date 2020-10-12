package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewFireEvent extends Event {
    public String name;
    public Integer crewID;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewFireEventTriggered((CrewFireEvent) event);
        }

        void onCrewFireEventTriggered(CrewFireEvent crewFireEvent);
    }
}
