package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.Module;

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

    // TODO: loadFromFile ModulesInfo.json
}