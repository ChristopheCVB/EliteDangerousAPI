package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ScientificResearchEvent extends Event {

  public Integer marketID;
  public String name;
  public String category;
  public Integer count;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onScientificResearchEventTriggered((ScientificResearchEvent) event);
    }

    void onScientificResearchEventTriggered(ScientificResearchEvent scientificResearchEvent);
  }
}
