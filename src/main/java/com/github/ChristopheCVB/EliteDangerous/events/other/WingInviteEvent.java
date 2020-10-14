package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class WingInviteEvent extends Event {
    public String name;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onWingInviteEventTriggered((WingInviteEvent) event);
        }

        void onWingInviteEventTriggered(WingInviteEvent wingInviteEvent);
    }
}
