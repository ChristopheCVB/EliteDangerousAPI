package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class CapShipBondEvent extends Event {

  public String victimFaction;
  public String awardingFaction;
  public Integer reward;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCapShipBondEventTriggered((CapShipBondEvent) event);
    }

    void onCapShipBondEventTriggered(CapShipBondEvent capShipBondEvent);
  }
}
