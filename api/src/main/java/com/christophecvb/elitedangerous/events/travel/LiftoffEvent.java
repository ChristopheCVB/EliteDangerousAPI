package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class LiftoffEvent extends Event {

  public Boolean playerControlled;
  public Double longitude, latitude;
  public String nearestDestination;
  public String nearestDestinationLocalised;
  public Integer bodyID;
  public Long systemAddress;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onLiftoffEventTriggered((LiftoffEvent) event);
    }

    void onLiftoffEventTriggered(LiftoffEvent liftoffEvent);
  }
}
