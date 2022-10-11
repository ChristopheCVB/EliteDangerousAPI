package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargetedStage2Event extends ShipTargetedStage1Event {

  public Double shieldHealth;
  public Double hullHealth;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargettedStage2EventTriggered((ShipTargetedStage2Event) event);
    }

    void onShipTargettedStage2EventTriggered(ShipTargetedStage2Event shipTargettedStage2Event);
  }
}
