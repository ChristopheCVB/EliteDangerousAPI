package com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty;

import com.google.gson.annotations.SerializedName;

public class BountyReward {
	@SerializedName("Faction")
	public String faction;
	@SerializedName("Reward")
	public Long reward;
}
