package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

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
	public Date expiry;
	public Boolean isComplete;
	public Boolean playerInTopRank;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onCommunityGoalEventTriggered((CommunityGoalEvent) event);
		}

		void onCommunityGoalEventTriggered(CommunityGoalEvent communityGoalEvent);
	}
}
