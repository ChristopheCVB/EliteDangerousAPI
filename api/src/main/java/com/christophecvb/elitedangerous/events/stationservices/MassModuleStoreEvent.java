package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.ModuleItem;
import java.util.List;

public class MassModuleStoreEvent extends Event {

  public Long marketID;
  public String ship;
  public Integer shipID;
  public List<ModuleItem> items;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMassModuleStoreEventTriggered((MassModuleStoreEvent) event);
    }

    void onMassModuleStoreEventTriggered(MassModuleStoreEvent massModuleStoreEvent);
  }
}
