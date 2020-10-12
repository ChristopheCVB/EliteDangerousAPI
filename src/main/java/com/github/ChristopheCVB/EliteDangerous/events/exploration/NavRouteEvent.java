package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class NavRouteEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNavRouteEventTriggered((NavRouteEvent) event);
        }

        void onNavRouteEventTriggered(NavRouteEvent navRouteEvent);
    }
}
