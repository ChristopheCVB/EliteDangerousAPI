package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierModulePackEvent extends CarrierPackEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierModulePackEventTriggered((CarrierModulePackEvent) event);
    }

    void onCarrierModulePackEventTriggered(CarrierModulePackEvent carrierModulePackEvent);
  }
}
