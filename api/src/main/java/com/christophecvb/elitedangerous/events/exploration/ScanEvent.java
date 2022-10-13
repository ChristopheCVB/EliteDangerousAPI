package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.scan.Ring;
import java.util.List;

public abstract class ScanEvent extends Event {

  public String scanType;
  public String bodyName;
  public Integer bodyID;
  public String starSystem;
  public Double distanceFromArrivalLS;
  public Double rotationPeriod;
  public Double surfaceTemperature;
  public List<Ring> rings;
  public Long semiMajorAxis;
  public Double eccentricity;
  public Double orbitalInclination;
  public Double periapsis;
  public Long orbitalPeriod;
  public Long systemAddress;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onScanEventTriggered((ScanEvent) event);
    }

    void onScanEventTriggered(ScanEvent scanEvent);
  }
}
