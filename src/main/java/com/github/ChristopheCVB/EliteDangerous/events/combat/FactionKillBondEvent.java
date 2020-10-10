package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FactionKillBondEvent extends Event {
	public String victimFaction;
	public String awardingFaction;
	public Integer reward;
	
	public FactionKillBondEvent(String timestamp) {
        super(timestamp);
    }
}
