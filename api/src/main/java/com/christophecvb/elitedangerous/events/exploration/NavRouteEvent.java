package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class NavRouteEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onNavRouteEventTriggered((NavRouteEvent) event);
    }

    void onNavRouteEventTriggered(NavRouteEvent navRouteEvent);
  }
}
