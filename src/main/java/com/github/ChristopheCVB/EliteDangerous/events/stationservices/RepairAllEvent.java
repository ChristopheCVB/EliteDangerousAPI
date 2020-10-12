package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class RepairAllEvent extends Event {
    public Long cost;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onRepairAllEventTriggered((RepairAllEvent) event);
        }

        void onRepairAllEventTriggered(RepairAllEvent repairAllEvent);
    }
}
