package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShieldStateEvent extends Event {

  public Boolean shieldsUp;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShieldStateEventTriggered((ShieldStateEvent) event);
    }

    void onShieldStateEventTriggered(ShieldStateEvent shieldStateEvent);
  }
}
