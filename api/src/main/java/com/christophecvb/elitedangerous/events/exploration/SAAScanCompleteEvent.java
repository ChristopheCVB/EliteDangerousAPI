package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;
import java.util.List;

public class SAAScanCompleteEvent extends Event {

  public String bodyName;
  public Integer bodyID, probesUsed, efficiencyTarget;
  public Long systemAddress;
  public List<String> descoverers;
  public List<String> mappers;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSAAScanCompleteEventTriggered((SAAScanCompleteEvent) event);
    }

    void onSAAScanCompleteEventTriggered(SAAScanCompleteEvent navRouteEvent);
  }
}
