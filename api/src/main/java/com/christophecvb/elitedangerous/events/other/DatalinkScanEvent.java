package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class DatalinkScanEvent extends Event {

  public String message;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onDatalinkScanEventTriggered((DatalinkScanEvent) event);
    }

    void onDatalinkScanEventTriggered(DatalinkScanEvent datalinkScanEvent);
  }
}
