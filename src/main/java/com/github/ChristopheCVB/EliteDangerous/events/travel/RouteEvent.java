package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.RouteItem;

import java.util.List;

public class RouteEvent extends Event {
    public List<RouteItem> route;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onUndockedEventTriggered((RouteEvent) event);
        }

        void onUndockedEventTriggered(RouteEvent undockedEvent);
    }
}
