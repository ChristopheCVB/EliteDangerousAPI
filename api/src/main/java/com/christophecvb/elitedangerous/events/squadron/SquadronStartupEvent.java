package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class SquadronStartupEvent extends SquadronEvent {

  public Integer currentRank;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSquadronStartupEventTriggered((SquadronStartupEvent) event);
    }

    void onSquadronStartupEventTriggered(SquadronStartupEvent squadronStartupEvent);
  }
}
