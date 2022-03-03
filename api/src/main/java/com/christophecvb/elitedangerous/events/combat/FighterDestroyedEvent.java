package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class FighterDestroyedEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onFighterDestroyedEventTriggered((FighterDestroyedEvent) event);
    }

    void onFighterDestroyedEventTriggered(FighterDestroyedEvent fighterDestroyedEvent);
  }
}
