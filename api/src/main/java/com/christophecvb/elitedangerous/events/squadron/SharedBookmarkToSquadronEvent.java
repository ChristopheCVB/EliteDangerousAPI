package com.christophecvb.elitedangerous.events.squadron;

import com.christophecvb.elitedangerous.events.Event;

public class SharedBookmarkToSquadronEvent extends SquadronEvent {

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onSharedBookmarkToSquadronEventTriggered((SharedBookmarkToSquadronEvent) event);
    }

    void onSharedBookmarkToSquadronEventTriggered(
        SharedBookmarkToSquadronEvent sharedBookmarkToSquadronEvent);
  }
}
