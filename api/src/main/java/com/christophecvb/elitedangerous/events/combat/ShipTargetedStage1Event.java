package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargetedStage1Event extends ShipTargetedStage0Event {

  public String pilotName;
  public String pilotNameLocalised;
  public String pilotRank;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargettedStage1EventTriggered((ShipTargetedStage1Event) event);
    }

    void onShipTargettedStage1EventTriggered(ShipTargetedStage1Event shipTargettedStage1Event);
  }
}
