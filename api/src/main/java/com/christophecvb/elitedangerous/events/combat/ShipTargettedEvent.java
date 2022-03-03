package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargettedEvent extends Event {

  public Boolean targetLocked;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargetedEventTriggered((ShipTargettedEvent) event);
    }

    void onShipTargetedEventTriggered(ShipTargettedEvent shipTargettedEvent);
  }
}
