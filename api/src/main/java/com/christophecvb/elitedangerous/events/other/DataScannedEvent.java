package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class DataScannedEvent extends Event {

  public static final String[] TYPES = {"DataLink", "DataPoint", "ListeningPost",
      "AbandonedDatalog", "WreckedShip"};

  public String type;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDataScannedEventTriggered((DataScannedEvent) event);
    }

    void onDataScannedEventTriggered(DataScannedEvent dataScannedEvent);
  }
}
