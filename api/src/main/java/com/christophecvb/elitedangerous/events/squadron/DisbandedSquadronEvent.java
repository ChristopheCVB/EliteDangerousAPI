package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class DisbandedSquadronEvent extends SquadronEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDisbandedSquadronEventTriggered((DisbandedSquadronEvent) event);
    }

    void onDisbandedSquadronEventTriggered(DisbandedSquadronEvent disbandedSquadronEvent);
  }
}
