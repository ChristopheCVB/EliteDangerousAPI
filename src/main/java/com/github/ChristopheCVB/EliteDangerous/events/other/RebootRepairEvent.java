package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

import java.util.List;

public class RebootRepairEvent extends Event {
    public List<String> modules;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onRebootRepairEventTriggered((RebootRepairEvent) event);
        }

        void onRebootRepairEventTriggered(RebootRepairEvent rebootRepairEvent);
    }
}
