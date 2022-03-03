package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class CrewMemberQuitsEvent extends Event {

  public String crew;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCrewMemberQuitsEventTriggered((CrewMemberQuitsEvent) event);
    }

    void onCrewMemberQuitsEventTriggered(CrewMemberQuitsEvent crewMemberQuitsEvent);
  }
}
