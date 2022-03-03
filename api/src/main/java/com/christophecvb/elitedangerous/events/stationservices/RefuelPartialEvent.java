package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class RefuelPartialEvent extends Event {

  public Integer cost;
  public Double amount;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onRefuelPartialEventTriggered((RefuelPartialEvent) event);
    }

    void onRefuelPartialEventTriggered(RefuelPartialEvent refuelPartialEvent);
  }
}
