package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class SelfDestructEvent extends Event {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSelfDestructEventTriggered((SelfDestructEvent) event);
    }

    void onSelfDestructEventTriggered(SelfDestructEvent selfDestructEvent);
  }
}
