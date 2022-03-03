package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class CockpitBreachedEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCockpitBreachedTriggered((CockpitBreachedEvent) event);
    }

    void onCockpitBreachedTriggered(CockpitBreachedEvent cockpitBreachedEvent);
  }
}
