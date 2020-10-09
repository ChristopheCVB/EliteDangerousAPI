package com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.BountyInfo;

import java.util.List;

public class DefaultBounty implements BountyInfo {

	private String target, victimsFaction;
	private Long totalReward;
	private List<BountyReward> rewards;

	public DefaultBounty(String target, String victimsFaction, Long totalReward, List<BountyReward> rewards) {
		this.target = target;
		this.victimsFaction = victimsFaction;
		this.totalReward = totalReward;
		this.rewards = rewards;
	}

	public String getTarget() {
		return target;
	}

	public String getVictimsFaction() {
		return victimsFaction;
	}

	public Long getTotalReward() {
		return totalReward;
	}

	public List<BountyReward> getRewards() {
		return rewards;
	}

}
