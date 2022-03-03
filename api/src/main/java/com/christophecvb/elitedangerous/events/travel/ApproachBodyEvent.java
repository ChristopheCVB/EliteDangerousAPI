package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class ApproachBodyEvent extends Event {

  public String starSystem;
  public String body;
  public Integer bodyID;
  public Long systemAddress;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onApproachBodyEventTriggered((ApproachBodyEvent) event);
    }

    void onApproachBodyEventTriggered(ApproachBodyEvent approachBodyEvent);
  }
}
