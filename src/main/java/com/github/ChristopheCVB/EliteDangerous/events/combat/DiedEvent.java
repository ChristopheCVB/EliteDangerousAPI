package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class DiedEvent extends Event {
	
	public DiedEvent(String timestamp) {
        super(timestamp);
    }
}
