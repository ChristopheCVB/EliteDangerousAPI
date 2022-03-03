package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class ScanStarEvent extends ScanEvent {

  public String starType;
  public String luminosity;
  public Long systemAddress;
  public Double stellarMass;
  public Long radius;
  public Double absoluteMagnitude;
  @SerializedName("Age_MY")
  public Long ageMY;
  public Boolean wasMapped;
  public Boolean wasDiscovered;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onScanStarEventTriggered((ScanStarEvent) event);
    }

    void onScanStarEventTriggered(ScanStarEvent scanStarEvent);
  }
}
