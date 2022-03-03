package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class DockSRVEvent extends DockEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDockSRVEventTriggered((DockSRVEvent) event);
    }

    void onDockSRVEventTriggered(DockSRVEvent dockSRVEvent);
  }
}
