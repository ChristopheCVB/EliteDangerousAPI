package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class InterdictedEvent extends Event {
	public Boolean submitted, isPlayer;
	public String interdictor, faction, power;
	public Integer combatRank;
}
