package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ShipyardSellEvent extends Event {

  public String shipType, shipTypeLocalised;
  public Integer sellShipID;
  public Long shipPrice, marketID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipyardSellEventTriggered((ShipyardSellEvent) event);
    }

    void onShipyardSellEventTriggered(ShipyardSellEvent shipyardSellEvent);
  }
}
