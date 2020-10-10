package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CollectCargoEvent extends Event {
	
	public String type;
	public Long missionID;
	public Boolean stolen;
	
	public CollectCargoEvent(String timestamp) {
        super(timestamp);
    }
}
