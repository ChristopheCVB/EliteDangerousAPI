package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class HullDamageEvent extends Event {

  public Double health;
  public Boolean playerPilot;
  public Boolean fighter;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onHullDamageEventTriggered((HullDamageEvent) event);
    }

    void onHullDamageEventTriggered(HullDamageEvent hullDamageEvent);
  }
}
