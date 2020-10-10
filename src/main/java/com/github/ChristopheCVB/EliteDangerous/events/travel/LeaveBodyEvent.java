package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LeaveBodyEvent extends Event {
	public String starSystem, body;
	public Long systemAddress;
	public Integer bodyID;
	
	public LeaveBodyEvent(String timestamp) {
        super(timestamp);
    }
}
