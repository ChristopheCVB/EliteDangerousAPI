package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class BuyDronesEvent extends Event {

  public String type;
  public Integer count;
  public Integer buyPrice;
  public Integer totalCost;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onBuyDronesEventTriggered((BuyDronesEvent) event);
    }

    void onBuyDronesEventTriggered(BuyDronesEvent buyDronesEvent);
  }
}
