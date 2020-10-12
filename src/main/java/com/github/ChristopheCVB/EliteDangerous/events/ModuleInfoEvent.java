package com.github.ChristopheCVB.EliteDangerous.events;

public class ModuleInfoEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onModuleInfoEventTriggered((ModuleInfoEvent) event);
        }

        void onModuleInfoEventTriggered(ModuleInfoEvent moduleInfoEvent);
    }
}
