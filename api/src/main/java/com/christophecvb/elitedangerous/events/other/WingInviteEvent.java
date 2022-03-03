package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class WingInviteEvent extends Event {

  public String name;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onWingInviteEventTriggered((WingInviteEvent) event);
    }

    void onWingInviteEventTriggered(WingInviteEvent wingInviteEvent);
  }
}
