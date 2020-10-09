package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class DiscoveryScanEvent extends Event {
	
	private Long systemAddress;
	private Integer bodies;

	public DiscoveryScanEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.bodies = JsonUtils.pullInt(jsonEvent, "Body");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getBodies() {
		return bodies;
	}

}
