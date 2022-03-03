package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.EliteDangerousAPI;
import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.backpack.BackpackItem;
import com.christophecvb.elitedangerous.utils.GameFiles;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class BackpackEvent extends Event {

  public List<BackpackItem> items;
  public List<BackpackItem> components;
  public List<BackpackItem> consumables;
  public List<BackpackItem> data;

  public static BackpackEvent loadFromFile() {
    BackpackEvent backpackEvent = null;

    File backpackFile = GameFiles.getExistingInstance().getBackpackFile();
    if (backpackFile != null && backpackFile.exists()) {
      try {
        backpackEvent = EliteDangerousAPI.GSON.fromJson(
            String.join("", Files.readAllLines(backpackFile.toPath(), StandardCharsets.UTF_8)),
            BackpackEvent.class);
      } catch (IOException ignored) {
      }
    }

    return backpackEvent;
  }

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onStatusEventTriggered((BackpackEvent) event);
    }

    void onStatusEventTriggered(BackpackEvent statusEvent);
  }
}
