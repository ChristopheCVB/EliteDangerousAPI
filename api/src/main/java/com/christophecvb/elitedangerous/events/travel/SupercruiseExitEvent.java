package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class SupercruiseExitEvent extends Event {

  public String starSystem;
  public String body;
  public String bodyType;
  private Integer bodyID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSupercruiseExitEventTriggered((SupercruiseExitEvent) event);
    }

    void onSupercruiseExitEventTriggered(SupercruiseExitEvent supercruiseExitEvent);
  }
}
