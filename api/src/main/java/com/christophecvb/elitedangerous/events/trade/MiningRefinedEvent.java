package com.christophecvb.elitedangerous.events.trade;

import com.christophecvb.elitedangerous.events.Event;

public class MiningRefinedEvent extends Event {

  public String type;
  public String typeLocalised;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onMiningRefinedEventTriggered((MiningRefinedEvent) event);
    }

    void onMiningRefinedEventTriggered(MiningRefinedEvent miningRefinedEvent);
  }
}
