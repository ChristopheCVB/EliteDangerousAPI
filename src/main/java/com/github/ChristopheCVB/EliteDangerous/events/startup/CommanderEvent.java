package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommanderEvent extends Event {
	
	public String name;
	public String FID;
	
	public CommanderEvent(String timestamp) {
        super(timestamp);
    }
}
