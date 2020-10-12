package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FactionKillBondEvent extends Event {
    public String victimFaction;
    public String awardingFaction;
    public Integer reward;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFactionKillBondEventTriggered((FactionKillBondEvent) event);
        }

        void onFactionKillBondEventTriggered(FactionKillBondEvent factionKillBondEvent);
    }
}
