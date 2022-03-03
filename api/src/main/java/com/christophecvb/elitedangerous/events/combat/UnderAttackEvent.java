package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class UnderAttackEvent extends Event {

  public String target;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onUnderAttackEventTriggered((UnderAttackEvent) event);
    }

    void onUnderAttackEventTriggered(UnderAttackEvent underAttackEvent);
  }
}
