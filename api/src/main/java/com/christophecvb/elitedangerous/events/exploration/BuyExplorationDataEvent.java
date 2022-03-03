package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class BuyExplorationDataEvent extends Event {

  public String system;
  public Integer cost;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onBuyExplorationDataEventTriggered((BuyExplorationDataEvent) event);
    }

    void onBuyExplorationDataEventTriggered(BuyExplorationDataEvent buyExplorationDataEvent);
  }
}
