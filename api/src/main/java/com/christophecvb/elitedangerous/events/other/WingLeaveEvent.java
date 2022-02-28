package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class WingLeaveEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onWingLeaveEventTriggered((WingLeaveEvent) event);
        }

        void onWingLeaveEventTriggered(WingLeaveEvent wingLeaveEvent);
    }
}
