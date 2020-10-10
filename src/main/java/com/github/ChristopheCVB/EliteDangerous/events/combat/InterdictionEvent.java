package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class InterdictionEvent extends Event {
	public Boolean success, isPlayer;
	public String interdictor, faction, power;
	public Integer combatRank;
	
	public InterdictionEvent(String timestamp) {
        super(timestamp);
    }
}
