package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class SellDronesEvent extends Event {

  public String type;
  public Integer count;
  public Long sellPrice, totalSale;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSellDronesEventTriggered((SellDronesEvent) event);
    }

    void onSellDronesEventTriggered(SellDronesEvent sellDronesEvent);
  }
}
