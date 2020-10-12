package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.Module;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.Gson;

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

        File modulesInfoFile = GameFilesUtils.getModulesInfoFile();
        if (modulesInfoFile != null && modulesInfoFile.exists()) {
            try {
                moduleInfoEvent = new Gson().fromJson(String.join("", Files.readAllLines(modulesInfoFile.toPath(), StandardCharsets.UTF_8)), ModuleInfoEvent.class);
            }
            catch (IOException ignored) {}
        }

        return moduleInfoEvent;
    }
}