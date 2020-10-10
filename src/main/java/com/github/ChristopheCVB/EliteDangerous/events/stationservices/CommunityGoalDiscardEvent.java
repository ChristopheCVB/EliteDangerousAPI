package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommunityGoalDiscardEvent extends Event {
	
	public Integer cgid;
	public String name;
	public String system;
	
	public CommunityGoalDiscardEvent(String timestamp) {
        super(timestamp);
    }
}
