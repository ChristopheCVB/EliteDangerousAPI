package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.EliteDangerousAPI;
import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Module;
import com.christophecvb.elitedangerous.utils.GameFiles;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ModuleInfoEvent extends Event {

  public List<Module> modules;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onModuleInfoEventTriggered((ModuleInfoEvent) event);
    }

    void onModuleInfoEventTriggered(ModuleInfoEvent moduleInfoEvent);
  }

  public static ModuleInfoEvent loadFromFile() {
    ModuleInfoEvent moduleInfoEvent = null;

    File modulesInfoFile = GameFiles.getExistingInstance().getModulesInfoFile();
    if (modulesInfoFile != null && modulesInfoFile.exists()) {
      try {
        moduleInfoEvent = EliteDangerousAPI.GSON.fromJson(
            String.join("", Files.readAllLines(modulesInfoFile.toPath(), StandardCharsets.UTF_8)),
            ModuleInfoEvent.class);
      } catch (IOException ignored) {
      }
    }

    return moduleInfoEvent;
  }
}