package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommanderEvent extends Event {

  public String name;
  @SerializedName("FID")
  public String fid;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCommanderEventTriggered((CommanderEvent) event);
    }

    void onCommanderEventTriggered(CommanderEvent commanderEvent);
  }
}
