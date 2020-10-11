package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommunityGoalDiscardEvent extends Event {
	@SerializedName("CGID")
	public Integer cgid;
	public String name;
	public String system;
}
