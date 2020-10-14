package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class WingAddEvent extends Event {
    public String name;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onWingAddEventTriggered((WingAddEvent) event);
        }

        void onWingAddEventTriggered(WingAddEvent wingAddEvent);
    }
}
