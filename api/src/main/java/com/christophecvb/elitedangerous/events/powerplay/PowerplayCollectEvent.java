package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

public class PowerplayCollectEvent extends PowerplayDistributionEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onPowerplayCollectEventTriggered((PowerplayCollectEvent) event);
    }

    void onPowerplayCollectEventTriggered(PowerplayCollectEvent powerplayCollectEvent);
  }
}
