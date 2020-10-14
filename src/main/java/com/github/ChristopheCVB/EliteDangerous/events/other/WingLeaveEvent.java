package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class WingLeaveEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onWingLeaveEventTriggered((WingLeaveEvent) event);
        }

        void onWingLeaveEventTriggered(WingLeaveEvent wingLeaveEvent);
    }
}
