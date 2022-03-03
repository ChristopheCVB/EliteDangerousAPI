package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.StoredModule;
import java.util.List;

public class StoredModulesEvent extends Event {

  public Long marketID;
  public String stationName, starSystem;
  public List<StoredModule> items;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onStoredModulesEventTriggered((StoredModulesEvent) event);
    }

    void onStoredModulesEventTriggered(StoredModulesEvent storedModulesEvent);
  }
}
