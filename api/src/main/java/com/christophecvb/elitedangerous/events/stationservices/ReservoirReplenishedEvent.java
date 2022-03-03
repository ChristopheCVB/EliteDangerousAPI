package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ReservoirReplenishedEvent extends Event {

  public Double fuelMain;
  public Double fuelReservoir;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onReservoirReplenishedEventTriggered((ReservoirReplenishedEvent) event);
    }

    void onReservoirReplenishedEventTriggered(ReservoirReplenishedEvent reservoirReplenishedEvent);
  }
}
