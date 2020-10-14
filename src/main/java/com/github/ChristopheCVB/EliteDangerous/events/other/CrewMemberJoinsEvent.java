package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewMemberJoinsEvent extends Event {
    public String crew;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewMemberJoinsEventTriggered((CrewMemberJoinsEvent) event);
        }

        void onCrewMemberJoinsEventTriggered(CrewMemberJoinsEvent crewMemberJoinsEvent);
    }
}
