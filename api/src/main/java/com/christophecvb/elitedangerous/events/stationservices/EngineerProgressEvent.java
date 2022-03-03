package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.engineer.Engineer;
import java.util.List;

public class EngineerProgressEvent extends Event {

  public List<Engineer> engineers;
  public Integer rank;
  public Double rankProgress;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onEngineerProgressEventTriggered((EngineerProgressEvent) event);
    }

    void onEngineerProgressEventTriggered(EngineerProgressEvent engineerProgressEvent);
  }
}
