package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class SquadronDemotionEvent extends SquadronXmotionEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSquadronDemotionEventTriggered((SquadronDemotionEvent) event);
    }

    void onSquadronDemotionEventTriggered(SquadronDemotionEvent squadronDemotionEvent);
  }
}
