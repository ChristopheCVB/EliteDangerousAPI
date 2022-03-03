package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class CrewMemberRoleChangeEvent extends Event {

  public String crew;
  public String role;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCrewMemberRoleChangeEventTriggered((CrewMemberRoleChangeEvent) event);
    }

    void onCrewMemberRoleChangeEventTriggered(CrewMemberRoleChangeEvent crewMemberRoleChangeEvent);
  }
}
