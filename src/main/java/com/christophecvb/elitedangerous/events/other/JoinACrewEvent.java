package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class JoinACrewEvent extends Event {
    public String captain;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onJoinACrewEventTriggered((JoinACrewEvent) event);
        }

        void onJoinACrewEventTriggered(JoinACrewEvent joinACrewEvent);
    }
}
