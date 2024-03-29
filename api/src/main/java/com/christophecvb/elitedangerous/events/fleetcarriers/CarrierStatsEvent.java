package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.CrewItem;
import com.christophecvb.elitedangerous.models.Finance;
import com.christophecvb.elitedangerous.models.Pack;
import com.christophecvb.elitedangerous.models.SpaceUsage;
import java.util.List;

public class CarrierStatsEvent extends Event {

  public Long carrierID;
  public String callsign;
  public String name;
  public String dockingAccess;
  public boolean allowNotorious;
  public Integer fuelLevel;
  public Float jumpRangeCurr;
  public Float jumpRangeMax;
  public Boolean pendingDecommission;
  public SpaceUsage spaceUsage;
  public Finance finance;
  public List<CrewItem> crew;
  public List<Pack> shipPacks;
  public List<Pack> modulePacks;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierStatsEventTriggered((CarrierStatsEvent) event);
    }

    void onCarrierStatsEventTriggered(CarrierStatsEvent carrierStatsEvent);
  }
}
