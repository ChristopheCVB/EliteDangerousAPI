package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ApproachBodyEvent extends Event {
	
	public String starSystem;
	public String body;
	public Integer bodyID;
	public Long systemAddress;
	
	public ApproachBodyEvent(String timestamp) {
        super(timestamp);
    }
}
