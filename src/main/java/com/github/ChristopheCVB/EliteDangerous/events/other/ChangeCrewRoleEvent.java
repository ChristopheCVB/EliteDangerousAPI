package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ChangeCrewRoleEvent extends Event {
    public String role;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onChangeCrewRoleEventTriggered((ChangeCrewRoleEvent) event);
        }

        void onChangeCrewRoleEventTriggered(ChangeCrewRoleEvent changeCrewRoleEvent);
    }
}
