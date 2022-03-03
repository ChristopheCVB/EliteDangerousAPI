package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class SellExplorationDataEvent extends Event {

  public String[] systems, discovered;
  public Integer baseValue, bonus, totalEarnings;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSellExplorationDataEventTriggered((SellExplorationDataEvent) event);
    }

    void onSellExplorationDataEventTriggered(SellExplorationDataEvent sellExplorationDataEvent);
  }
}
