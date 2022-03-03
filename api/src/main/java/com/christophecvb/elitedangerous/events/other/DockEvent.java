package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public abstract class DockEvent extends Event {

  @SerializedName("ID")
  public String id;
}
