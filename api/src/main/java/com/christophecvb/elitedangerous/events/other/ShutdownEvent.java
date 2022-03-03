package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class ShutdownEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShutdownEventTriggered((ShutdownEvent) event);
    }

    void onShutdownEventTriggered(ShutdownEvent shutdownEvent);
  }
}
