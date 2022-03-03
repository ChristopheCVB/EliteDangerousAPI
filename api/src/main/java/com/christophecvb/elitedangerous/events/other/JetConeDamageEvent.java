package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class JetConeDamageEvent extends Event {

  public String module;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onJetConeDamageEventTriggered((JetConeDamageEvent) event);
    }

    void onJetConeDamageEventTriggered(JetConeDamageEvent jetConeDamageEvent);
  }
}
