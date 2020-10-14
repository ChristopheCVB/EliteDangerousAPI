package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class NpcCrewRankEvent extends Event {
    public Long npcCrewId;
    public String npcCrewName;
    public Integer rankCombat;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNpcCrewPaidWageEventTriggered((NpcCrewRankEvent) event);
        }

        void onNpcCrewPaidWageEventTriggered(NpcCrewRankEvent npcCrewRankEvent);
    }
}
