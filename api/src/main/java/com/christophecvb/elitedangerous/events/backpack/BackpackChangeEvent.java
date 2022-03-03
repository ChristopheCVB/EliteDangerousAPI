package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.backpack.BackpackItem;
import java.util.List;

public class BackpackChangeEvent extends Event {

  public List<BackpackItem> added;
  public List<BackpackItem> removed;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onStatusEventTriggered((BackpackChangeEvent) event);
    }

    void onStatusEventTriggered(BackpackChangeEvent statusEvent);
  }
}
