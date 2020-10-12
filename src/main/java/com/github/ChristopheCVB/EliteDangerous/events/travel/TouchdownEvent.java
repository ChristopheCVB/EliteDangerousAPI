package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class TouchdownEvent extends Event {
    public Boolean playerControlled;
    public Double latitude, longitude;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onTouchdownEventTriggered((TouchdownEvent) event);
        }

        void onTouchdownEventTriggered(TouchdownEvent touchdownEvent);
    }
}
