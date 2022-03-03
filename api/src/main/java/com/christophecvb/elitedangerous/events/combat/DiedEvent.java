package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public abstract class DiedEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDiedEventTriggered((DiedEvent) event);
    }

    void onDiedEventTriggered(DiedEvent diedEvent);
  }
}
