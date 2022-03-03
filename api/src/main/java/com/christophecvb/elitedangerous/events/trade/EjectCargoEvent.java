package com.christophecvb.elitedangerous.events.trade;

import com.christophecvb.elitedangerous.events.Event;

public class EjectCargoEvent extends Event {

  public String type;
  public String typeLocalised;
  public String powerplayOrigin;
  public Integer count;
  public Long missionID;
  public Boolean abandoned;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onEjectCargoEventTriggered((EjectCargoEvent) event);
    }

    void onEjectCargoEventTriggered(EjectCargoEvent ejectCargoEvent);
  }
}
