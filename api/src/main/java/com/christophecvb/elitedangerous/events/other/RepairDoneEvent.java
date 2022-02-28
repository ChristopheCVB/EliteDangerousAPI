package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class RepairDoneEvent extends Event {
    public Double hullRepaired;
    public Double cockpitRepaired;
    public Double corrosionRepaired;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onRepairDoneEventTriggered((RepairDoneEvent) event);
        }

        void onRepairDoneEventTriggered(RepairDoneEvent repairDoneEvent);
    }
}
