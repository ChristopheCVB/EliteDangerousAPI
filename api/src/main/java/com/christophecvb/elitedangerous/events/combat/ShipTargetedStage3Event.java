package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargetedStage3Event extends ShipTargetedStage2Event {

  public String faction;
  public String legalStatus;
  public String subsystem;
  public String subsystemLocalised;
  public Double subsystemHealth;
  public String power;
  public Long bounty;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onShipTargettedStage3EventTriggered((ShipTargetedStage3Event) event);
    }

    void onShipTargettedStage3EventTriggered(ShipTargetedStage3Event shipTargettedStage3Event);
  }
}
