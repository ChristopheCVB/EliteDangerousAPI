package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class BuyAmmoEvent extends Event {

  public Integer cost;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onBuyAmmoEventTriggered((BuyAmmoEvent) event);
    }

    void onBuyAmmoEventTriggered(BuyAmmoEvent buyAmmoEvent);
  }
}
