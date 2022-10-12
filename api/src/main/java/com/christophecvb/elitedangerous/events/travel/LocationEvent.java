package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Conflict;
import com.christophecvb.elitedangerous.models.Faction;
import com.christophecvb.elitedangerous.models.StationEconomy;
import java.util.List;

public class LocationEvent extends Event {

  public String starSystem;
  public String systemAllegiance;
  public String systemEconomy;
  public String systemEconomyLocalised;
  public String systemSecondEconomy;
  public String systemSecondEconomyLocalised;
  public String systemGovernment;
  public String systemGovernmentLocalised;
  public String systemSecurity;
  public String systemSecurityLocalised;
  public String body;
  public String bodyType;
  public Faction systemFaction;
  public String powerplayState;
  public String stationName;
  public String stationType;
  public String stationEconomy;
  public Faction stationFaction;
  public String stationAllegiance;
  public String stationGovernment;
  public String stationEconomyLocalised;
  public String stationGovernmentLocalised;
  public Double[] starPos;
  public Long systemAddress, population, marketID;
  public Integer bodyID;
  public Boolean docked;
  public List<Faction> factions;
  public List<Conflict> conflicts;
  public List<String> powers, stationServices;
  public List<StationEconomy> stationEconomies;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onLocationEventTriggered((LocationEvent) event);
    }

    void onLocationEventTriggered(LocationEvent locationEvent);
  }
}
