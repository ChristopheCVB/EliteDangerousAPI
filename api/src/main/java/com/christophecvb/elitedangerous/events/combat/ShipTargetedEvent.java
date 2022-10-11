package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargetedEvent extends Event {

  public Boolean targetLocked;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargetedEventTriggered((ShipTargetedEvent) event);
    }

    void onShipTargetedEventTriggered(ShipTargetedEvent shipTargetedEvent);
  }
}
