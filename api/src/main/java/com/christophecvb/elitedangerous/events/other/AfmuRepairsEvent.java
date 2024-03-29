package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class AfmuRepairsEvent extends Event {

  public String module;
  public String moduleLocalised;
  public Boolean fullyRepaired;
  public Float health;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onAfmuRepairsEventTriggered((AfmuRepairsEvent) event);
    }

    void onAfmuRepairsEventTriggered(AfmuRepairsEvent afmuRepairsEvent);
  }
}
