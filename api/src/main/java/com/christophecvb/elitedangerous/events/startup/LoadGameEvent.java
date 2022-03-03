package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class LoadGameEvent extends Event {

  public String commander;
  @SerializedName("FID")
  public String fid;
  public String ship;
  public String shipLocalised;
  public String shipName;
  public String shipIdent;
  public String gameMode;
  public String group;
  public Integer shipID;
  public Double fuelLevel;
  public Double fuelCapacity;
  public Long credits;
  public Long loan;
  public Boolean horizons;
  public Boolean startLanded;
  public Boolean startDead;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onLoadGameEventTriggered((LoadGameEvent) event);
    }

    void onLoadGameEventTriggered(LoadGameEvent loadGameEvent);
  }
}
