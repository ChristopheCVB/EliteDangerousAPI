package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class MaterialDiscoveredEvent extends Event {

  public String category, name;
  public Integer discoveryNumber;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMaterialDiscoveredEventTriggered((MaterialDiscoveredEvent) event);
    }

    void onMaterialDiscoveredEventTriggered(MaterialDiscoveredEvent materialDiscoveredEvent);
  }
}
