package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SAAScanCompleteEvent extends Event {
	public String bodyName;
	public Integer bodyID, probesUsed, efficiencyTarget;
	public Long systemAddress;
	
	public SAAScanCompleteEvent(String timestamp) {
        super(timestamp);
    }
}
