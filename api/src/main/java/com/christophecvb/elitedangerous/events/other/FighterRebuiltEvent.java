package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class FighterRebuiltEvent extends Event {

  public String loadout;
  @SerializedName("ID")
  public Long id;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onFighterRebuiltEventTriggered((FighterRebuiltEvent) event);
    }

    void onFighterRebuiltEventTriggered(FighterRebuiltEvent fighterRebuiltEvent);
  }
}
