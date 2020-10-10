package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class PowerplayEvent extends Event {
	
	public String power;
	public Integer rank;
	public Integer merits;
	public Integer votes;
	public Integer timePledged;
	
	public PowerplayEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.power = JsonUtils.pullString(jsonEvent, "Power");
        this.rank = JsonUtils.pullInt(jsonEvent, "Rank");
        this.merits = JsonUtils.pullInt(jsonEvent, "Merits");
        this.votes = JsonUtils.pullInt(jsonEvent, "Votes");
        this.timePledged = JsonUtils.pullInt(jsonEvent, "TimePledged");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getPower() {
		return power;
	}

	public Integer getRank() {
		return rank;
	}

	public Integer getMerits() {
		return merits;
	}

	public Integer getVotes() {
		return votes;
	}

	public Integer getTimePledged() {
		return timePledged;
	}
	
}
