package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DiedByPVPEvent extends DiedEvent {
    public String killerName;
    public String killerShip;
    public String killerRank;

    public interface Listener extends DiedEvent.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onDiedByPVPEventTriggered((DiedByPVPEvent) event);
        }

        void onDiedByPVPEventTriggered(DiedByPVPEvent diedByPVPEvent);
    }
}