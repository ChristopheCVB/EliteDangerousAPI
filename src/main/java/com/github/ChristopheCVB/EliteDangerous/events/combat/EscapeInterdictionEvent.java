package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class EscapeInterdictionEvent extends Event {
	public String interdictor;
	public Boolean isPlayer;
	
	public EscapeInterdictionEvent(String timestamp) {
        super(timestamp);
    }
}
