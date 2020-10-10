package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommunityGoalJoinEvent extends Event {
	@SerializedName("CGID")
	public Integer cgid;
	public String name;
	public String system;
	
	public CommunityGoalJoinEvent(String timestamp) {
		super(timestamp);
	}
}
