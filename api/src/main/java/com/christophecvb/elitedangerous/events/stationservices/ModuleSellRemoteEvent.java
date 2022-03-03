package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ModuleSellRemoteEvent extends Event {

  public Integer storageSlot, shipID;
  public String sellItem;
  public String sellItemLocalised;
  public String ship;
  public Long serverID, sellPrice;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onModuleSellRemoteEventTriggered((ModuleSellRemoteEvent) event);
    }

    void onModuleSellRemoteEventTriggered(ModuleSellRemoteEvent moduleSellRemoteEvent);
  }
}
