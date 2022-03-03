package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class WonATrophyForSquadronEvent extends SquadronEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onWonATrophyForSquadronEventTriggered((WonATrophyForSquadronEvent) event);
    }

    void onWonATrophyForSquadronEventTriggered(
        WonATrophyForSquadronEvent wonATrophyForSquadronEvent);
  }
}
