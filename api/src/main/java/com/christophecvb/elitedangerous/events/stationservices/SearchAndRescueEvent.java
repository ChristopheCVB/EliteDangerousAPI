package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class SearchAndRescueEvent extends Event {

  public Long marketID, reward;
  public String name, nameLocalised;
  public Integer count;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSearchAndRescueEventTriggered((SearchAndRescueEvent) event);
    }

    void onSearchAndRescueEventTriggered(SearchAndRescueEvent searchAndRescueEvent);
  }
}
