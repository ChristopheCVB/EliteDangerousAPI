package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class ContinuedEvent extends Event {

  public Long part;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onContinuedEventTriggered((ContinuedEvent) event);
    }

    void onContinuedEventTriggered(ContinuedEvent continuedEvent);
  }
}
