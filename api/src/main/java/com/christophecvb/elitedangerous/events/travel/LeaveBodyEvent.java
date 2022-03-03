package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class LeaveBodyEvent extends Event {

  public String starSystem, body;
  public Long systemAddress;
  public Integer bodyID;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onLeaveBodyEventTriggered((LeaveBodyEvent) event);
    }

    void onLeaveBodyEventTriggered(LeaveBodyEvent leaveBodyEvent);
  }
}
