package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class KickCrewMemberEvent extends Event {

  public String crew;
  public Boolean onCrime;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onKickCrewMemberEventTriggered((KickCrewMemberEvent) event);
    }

    void onKickCrewMemberEventTriggered(KickCrewMemberEvent kickCrewMemberEvent);
  }
}
