package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;

public class NpcCrewPaidWageEvent extends Event {
    public Long npcCrewId;
    public String npcCrewName;
    public Integer amount;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNpcCrewPaidWageEventTriggered((NpcCrewPaidWageEvent) event);
        }

        void onNpcCrewPaidWageEventTriggered(NpcCrewPaidWageEvent npcCrewPaidWageEvent);
    }
}
