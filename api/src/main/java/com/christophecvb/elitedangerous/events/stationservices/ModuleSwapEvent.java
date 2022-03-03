package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ModuleSwapEvent extends Event {

  public Long marketID;
  public String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
  public Integer shipID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onModuleSwapEventTriggered((ModuleSwapEvent) event);
    }

    void onModuleSwapEventTriggered(ModuleSwapEvent moduleSwapEvent);
  }
}
