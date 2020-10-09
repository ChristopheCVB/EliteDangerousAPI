package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class PvPKillEvent extends Event {
	
	private String victim;
	private Integer combatRank;
	
	public PvPKillEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.victim = JsonUtils.pullString(jsonEvent, "Victim");
        this.combatRank = JsonUtils.pullInt(jsonEvent, "CombatRank");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getVictim() {
		return victim;
	}

	public Integer getCombatRank() {
		return combatRank;
	}

}
