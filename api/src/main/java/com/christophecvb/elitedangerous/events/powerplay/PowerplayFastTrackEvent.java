package com.christophecvb.elitedangerous.events.powerplay;

import com.christophecvb.elitedangerous.events.Event;

public class PowerplayFastTrackEvent extends Event {

  public String power;
  public Integer cost;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onPowerplayFastTrackTriggered((PowerplayFastTrackEvent) event);
    }

    void onPowerplayFastTrackTriggered(PowerplayFastTrackEvent powerplayFastTrackEvent);
  }
}
