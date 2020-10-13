package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

import java.util.List;

public class BountyDefaultEvent extends BountyEvent {
	public Long totalReward;
	public List<Reward> rewards;
	public Integer sharedWithOthers;

	public static class Reward {
		public String faction;
		public Long reward;
	}

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onBountyDefaultEventTriggered((BountyDefaultEvent) event);
		}

		void onBountyDefaultEventTriggered(BountyDefaultEvent bountyDefaultEvent);
	}
}
