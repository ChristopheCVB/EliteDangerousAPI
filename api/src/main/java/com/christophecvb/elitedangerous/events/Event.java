package com.christophecvb.elitedangerous.events;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public abstract class Event {

  @SerializedName("timestamp")
  public Date timestamp;
  @SerializedName("event")
  public String type;

  public interface Listener {

    <T extends Event> void onTriggered(T event);
  }
}
