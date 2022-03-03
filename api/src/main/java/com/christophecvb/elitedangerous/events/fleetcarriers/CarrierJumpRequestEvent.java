package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierJumpRequestEvent extends Event {

  public Long carrierID;
  public String systemName;
  public String body;
  public Long systemAddress;
  public Integer bodyID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierJumpRequestEventTriggered((CarrierJumpRequestEvent) event);
    }

    void onCarrierJumpRequestEventTriggered(CarrierJumpRequestEvent carrierJumpRequestEvent);
  }
}
