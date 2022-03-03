package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierDecommissionEvent extends Event {

  public Long carrierID;
  public Long scrapRefund;
  public Long scrapTime;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierDecommissionEventTriggered((CarrierDecommissionEvent) event);
    }

    void onCarrierDecommissionEventTriggered(CarrierDecommissionEvent carrierJumpEvent);
  }
}
