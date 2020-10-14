package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.EliteDangerousAPI;
import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.Module;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFiles;

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

        File modulesInfoFile = GameFiles.getModulesInfoFile();
        if (modulesInfoFile != null && modulesInfoFile.exists()) {
            try {
                moduleInfoEvent = EliteDangerousAPI.GSON.fromJson(String.join("", Files.readAllLines(modulesInfoFile.toPath(), StandardCharsets.UTF_8)), ModuleInfoEvent.class);
            }
            catch (IOException ignored) {}
        }

        return moduleInfoEvent;
    }
}