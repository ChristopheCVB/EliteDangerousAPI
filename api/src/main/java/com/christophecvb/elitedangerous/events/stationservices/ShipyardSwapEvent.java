package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ShipyardSwapEvent extends Event {

  public String shipType, shipTypeLocalised, storeOldShip;
  public Integer shipID, storeShipID;
  public Long marketID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipyardSwapEventTriggered((ShipyardSwapEvent) event);
    }

    void onShipyardSwapEventTriggered(ShipyardSwapEvent shipyardSwapEvent);
  }
}
