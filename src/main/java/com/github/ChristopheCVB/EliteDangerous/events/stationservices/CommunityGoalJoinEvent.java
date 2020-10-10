package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommunityGoalJoinEvent extends Event {
	
	public Integer cgid;
	public String name;
	public String system;
	
	public CommunityGoalJoinEvent(String timestamp) {
		super(timestamp);
	}
}
