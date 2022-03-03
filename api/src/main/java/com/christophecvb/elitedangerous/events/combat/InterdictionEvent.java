package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class InterdictionEvent extends Event {

  public Boolean success, isPlayer;
  public String interdicted, faction, power;
  public Integer combatRank;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onInterdictionEventTriggered((InterdictionEvent) event);
    }

    void onInterdictionEventTriggered(InterdictionEvent interdictionEvent);
  }
}
