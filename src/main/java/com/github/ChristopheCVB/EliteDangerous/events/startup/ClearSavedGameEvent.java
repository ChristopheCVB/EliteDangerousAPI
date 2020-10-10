package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ClearSavedGameEvent extends Event {
	
	public String name;
	public String FID;
	
	public ClearSavedGameEvent(String timestamp) {
        super(timestamp);
    }
}
