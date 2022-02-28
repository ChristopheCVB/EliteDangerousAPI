package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

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
