package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class FactionKillBondEvent extends Event {

  public Integer reward;
  public String awardingFaction;
  public String victimFaction;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onFactionKillBondEventTriggered((FactionKillBondEvent) event);
    }

    void onFactionKillBondEventTriggered(FactionKillBondEvent factionKillBondEvent);
  }
}
