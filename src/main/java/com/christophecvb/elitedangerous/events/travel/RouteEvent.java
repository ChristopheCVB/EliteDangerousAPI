package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.RouteItem;

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
