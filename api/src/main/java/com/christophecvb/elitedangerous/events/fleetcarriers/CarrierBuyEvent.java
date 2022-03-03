package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierBuyEvent extends Event {

  public Long boughtAtMarket;
  public Long carrierID;
  public String location;
  public Long price;
  public String variant;
  public String callsign;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierBuyEventTriggered((CarrierBuyEvent) event);
    }

    void onCarrierBuyEventTriggered(CarrierBuyEvent carrierBuyEvent);
  }
}
