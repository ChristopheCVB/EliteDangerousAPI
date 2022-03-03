package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class DockingCancelledEvent extends Event {

  public String stationName;
  public String stationType;
  public Long marketID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDockingCancelledEventTriggered((DockingCancelledEvent) event);
    }

    void onDockingCancelledEventTriggered(DockingCancelledEvent dockingCancelledEvent);
  }
}
