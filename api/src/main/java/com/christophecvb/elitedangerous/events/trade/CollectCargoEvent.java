package com.christophecvb.elitedangerous.events.trade;

import com.christophecvb.elitedangerous.events.Event;

public class CollectCargoEvent extends Event {

  public String type;
  public Long missionID;
  public Boolean stolen;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCollectCargoEventTriggered((CollectCargoEvent) event);
    }

    void onCollectCargoEventTriggered(CollectCargoEvent collectCargoEvent);
  }
}
