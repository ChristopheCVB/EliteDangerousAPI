package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class NewCommanderEvent extends Event {
	
	public String name;
	public String FID;
	public String starterPackage;

	public NewCommanderEvent(String timestamp) {
        super(timestamp);
    }
}
