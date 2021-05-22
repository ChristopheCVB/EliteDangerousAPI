package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class SystemsShutdownEvent extends Event {
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSystemsShutdownEventTriggered((SystemsShutdownEvent) event);
        }

        void onSystemsShutdownEventTriggered(SystemsShutdownEvent systemsShutdownEvent);
    }
}
