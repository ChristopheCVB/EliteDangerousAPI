package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class EscapeInterdictionEvent extends Event {

  public String interdictor;
  public Boolean isPlayer;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onEscapeInterdictionEventTriggered((EscapeInterdictionEvent) event);
    }

    void onEscapeInterdictionEventTriggered(EscapeInterdictionEvent escapeInterdictionEvent);
  }
}
