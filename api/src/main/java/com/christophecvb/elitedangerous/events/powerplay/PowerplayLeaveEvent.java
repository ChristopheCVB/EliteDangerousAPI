package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

public class PowerplayLeaveEvent extends Event {

  public String power;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onPowerplayLeaveEventTriggered((PowerplayLeaveEvent) event);
    }

    void onPowerplayLeaveEventTriggered(PowerplayLeaveEvent powerplayLeaveEvent);
  }
}
