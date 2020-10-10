package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CapShipBondEvent extends Event {
	public String victimFaction;
	public String awardingFaction;
	public Integer reward;
	
	public CapShipBondEvent(String timestamp) {
        super(timestamp);
    }

}
