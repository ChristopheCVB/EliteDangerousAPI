package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class SendTextEvent extends Event {

  public String to;
  public String message;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSendTextEventTriggered((SendTextEvent) event);
    }

    void onSendTextEventTriggered(SendTextEvent sendTextEvent);
  }
}
