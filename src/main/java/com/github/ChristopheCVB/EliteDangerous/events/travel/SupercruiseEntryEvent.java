package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SupercruiseEntryEvent extends Event {
	
	private String starSystem;
	private Long SystemAddress;
	
	public SupercruiseEntryEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
		this.SystemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

		GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Long getSystemAddress() {
		return SystemAddress;
	}
}
