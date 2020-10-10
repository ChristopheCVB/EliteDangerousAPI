package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CommunityGoalEvent extends Event {
	@SerializedName("CGID")
	public Integer cgid;
	public Integer playerContribution;
	public Integer numContributors;
	public Integer topRankSize;
	public Integer playerPercentileBand;
	public Integer bonus;
	public String title;
	public String systemName;
	public String marketName;
	public String tierReached;
	public Long expiry;
	public Boolean isComplete;
	public Boolean playerInTopRank;
	
	public CommunityGoalEvent(String timestamp) {
		super(timestamp);
    }
}
