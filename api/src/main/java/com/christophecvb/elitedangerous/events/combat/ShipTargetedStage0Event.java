package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargetedStage0Event extends ShipTargetedEvent {

  public String ship;
  public String shipLocalised;
  public Integer scanStage;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargettedStage0EventTriggered((ShipTargetedStage0Event) event);
    }

    void onShipTargettedStage0EventTriggered(ShipTargetedStage0Event shipTargettedStage0Event);
  }
}
