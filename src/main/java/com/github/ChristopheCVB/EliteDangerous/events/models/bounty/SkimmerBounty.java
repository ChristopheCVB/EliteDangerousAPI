package com.github.ChristopheCVB.EliteDangerous.events.models.bounty;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.BountyInfo;

public class SkimmerBounty implements BountyInfo {
	
	private String faction, target, victimsFaction;
	private Long reward;
	
	public SkimmerBounty(String faction, String target, String victimsFaction, Long reward) {
		this.faction = faction;
		this.target = target;
		this.victimsFaction = victimsFaction;
		this.reward = reward;
	}

	public String getFaction() {
		return faction;
	}

	public String getTarget() {
		return target;
	}

	public String getVictimsFaction() {
		return victimsFaction;
	}

	public Long getReward() {
		return reward;
	}

}
