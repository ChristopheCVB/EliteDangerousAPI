package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

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
