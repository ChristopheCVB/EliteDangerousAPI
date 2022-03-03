package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class DockingGrantedEvent extends Event {

  public String stationName;
  public String stationType;
  public Long marketID;
  public Integer landingPad;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDockingGrantedEventTriggered((DockingGrantedEvent) event);
    }

    void onDockingGrantedEventTriggered(DockingGrantedEvent dockingGrantedEvent);
  }
}
