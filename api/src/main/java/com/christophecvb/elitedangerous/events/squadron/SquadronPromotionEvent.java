package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class SquadronPromotionEvent extends SquadronXmotionEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSquadronPromotionEventTriggered((SquadronPromotionEvent) event);
    }

    void onSquadronPromotionEventTriggered(SquadronPromotionEvent squadronPromotionEvent);
  }
}
