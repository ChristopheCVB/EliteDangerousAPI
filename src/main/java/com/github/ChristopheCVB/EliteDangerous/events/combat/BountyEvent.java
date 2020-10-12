package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.BountyReward;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.DefaultBounty;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.SkimmerBounty;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.BountyInfo;

import java.util.List;

public class BountyEvent extends Event {
	public String faction;
	public String target;
	public String victimsFaction;
	public Long reward;
	public Long totalReward;
	public List<BountyReward> rewards;

	public BountyInfo getBountyInfo() {
		if ("Skimmer".equals(target)) {
			return new SkimmerBounty(faction, target, victimsFaction, reward);
		}
		else {
			return new DefaultBounty(target, victimsFaction, totalReward, rewards);
		}
	}

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onBountyEventTriggered((BountyEvent) event);
		}

		void onBountyEventTriggered(BountyEvent bountyEvent);
	}
}
