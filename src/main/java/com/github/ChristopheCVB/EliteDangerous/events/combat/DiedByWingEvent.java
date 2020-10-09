package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Killer;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class DiedByWingEvent extends Event {

	private List<Killer> killers;

	public DiedByWingEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.killers = GameFilesUtils.createKillerList(JsonUtils.pullJsonArray(jsonEvent, "Killers"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<Killer> getKillers() {
		return killers;
	}
	
}
