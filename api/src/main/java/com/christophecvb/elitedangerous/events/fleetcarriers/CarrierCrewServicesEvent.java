package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierCrewServicesEvent extends Event {

  public String crewName, crewRole, operation;
  public Long carrierID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierCrewServicesEventTriggered((CarrierCrewServicesEvent) event);
    }

    void onCarrierCrewServicesEventTriggered(CarrierCrewServicesEvent carrierCrewServicesEvent);
  }
}
