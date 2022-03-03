package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class RefuelAllEvent extends Event {

  public Long cost;
  public Double amount;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onRefuelAllEventTriggered((RefuelAllEvent) event);
    }

    void onRefuelAllEventTriggered(RefuelAllEvent refuelAllEvent);
  }
}
