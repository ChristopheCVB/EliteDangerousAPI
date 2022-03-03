package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class KickedFromSquadronEvent extends SquadronEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onKickedFromSquadronEventTriggered((KickedFromSquadronEvent) event);
    }

    void onKickedFromSquadronEventTriggered(KickedFromSquadronEvent kickedFromSquadronEvent);
  }
}
