package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class TouchdownEvent extends Event {

  public Boolean playerControlled;
  public Double latitude, longitude;
  public String nearestDestination;
  public String nearestDestinationLocalised;
  public Integer bodyID;
  public Long systemAddress;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onTouchdownEventTriggered((TouchdownEvent) event);
    }

    void onTouchdownEventTriggered(TouchdownEvent touchdownEvent);
  }
}
