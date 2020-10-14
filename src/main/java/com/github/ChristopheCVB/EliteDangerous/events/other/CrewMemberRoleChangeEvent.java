package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CrewMemberRoleChangeEvent extends Event {
    public String crew;
    public String role;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCrewMemberRoleChangeEventTriggered((CrewMemberRoleChangeEvent) event);
        }

        void onCrewMemberRoleChangeEventTriggered(CrewMemberRoleChangeEvent crewMemberRoleChangeEvent);
    }
}
