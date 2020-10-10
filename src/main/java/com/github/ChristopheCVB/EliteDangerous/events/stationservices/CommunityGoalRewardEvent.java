package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CommunityGoalRewardEvent extends Event{
	
	public Integer cgid;
	public Integer reward;
	public String name;
	public String system;
	
	public CommunityGoalRewardEvent(String timestamp) {
        super(timestamp);
    }
}
