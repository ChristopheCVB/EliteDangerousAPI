package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PowerplayEvent extends Event {
	public String power;
	public Integer rank;
	public Integer merits;
	public Integer votes;
	public Integer timePledged;
	
	public PowerplayEvent(String timestamp) {
        super(timestamp);
    }
}
