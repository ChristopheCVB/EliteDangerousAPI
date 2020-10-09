package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.BountyReward;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.DefaultBounty;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.SkimmerBounty;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.BountyInfo;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class BountyEvent extends Event {
	
	private String faction, target, victimsFaction;
	private Long reward, totalReward;
	private List<BountyReward> rewards;
	
	public BountyEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.target = JsonUtils.pullString(jsonEvent, "Target");
        this.victimsFaction = JsonUtils.pullString(jsonEvent, "VictimsFaction");
        this.reward = JsonUtils.pullLong(jsonEvent, "Reward");
        this.totalReward = JsonUtils.pullLong(jsonEvent, "TotalReward");
        this.rewards = GameFilesUtils.createBountyRewardList(JsonUtils.pullJsonArray(jsonEvent, "Rewards"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public BountyInfo getBountyInfo() {
		if(target.equals("Skimmer")) {
			return new SkimmerBounty(faction, target, victimsFaction, reward);
		}else {
			return new DefaultBounty(target, victimsFaction, totalReward, rewards);
		}
	}

}
