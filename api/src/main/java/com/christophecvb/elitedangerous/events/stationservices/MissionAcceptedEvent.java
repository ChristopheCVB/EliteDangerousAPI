package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import java.util.Date;

public class MissionAcceptedEvent extends Event {

  public String faction;
  public String name;
  public String localisedName;
  public String targetFaction;
  public String destinationSystem;
  public String destinationStation;
  public String influence;
  public String reputation;
  public Long reward;
  public Long missionID;
  public Date expiry;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMissionAcceptedEventTriggered((MissionAcceptedEvent) event);
    }

    void onMissionAcceptedEventTriggered(MissionAcceptedEvent missionAcceptedEvent);
  }
}
