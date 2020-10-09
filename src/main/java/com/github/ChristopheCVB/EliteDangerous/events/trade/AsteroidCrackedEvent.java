package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class AsteroidCrackedEvent extends Event {
	
	private String body;

	public AsteroidCrackedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.body = JsonUtils.pullString(jsonEvent, "Body");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getBody() {
		return body;
	}
}
