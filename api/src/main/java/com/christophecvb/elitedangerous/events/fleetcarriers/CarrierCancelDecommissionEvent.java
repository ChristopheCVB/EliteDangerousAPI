package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierCancelDecommissionEvent extends Event {

  public Long carrierID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierCancelDecommissionEventTriggered((CarrierCancelDecommissionEvent) event);
    }

    void onCarrierCancelDecommissionEventTriggered(
        CarrierCancelDecommissionEvent CarrierCancelDecommissionEvent);
  }
}
