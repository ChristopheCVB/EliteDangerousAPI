package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class RepairEvent extends Event {

  public String item;
  public Long cost;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onRepairEventTriggered((RepairEvent) event);
    }

    void onRepairEventTriggered(RepairEvent repairEvent);
  }
}
