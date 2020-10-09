package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SupercruiseExitEvent extends Event {

	private String starSystem, body, bodyType;
	private Long systemAddress;
	private Integer bodyID;
	
	public SupercruiseExitEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.body = JsonUtils.pullString(jsonEvent, "Body");
        this.bodyType = JsonUtils.pullString(jsonEvent, "BodyType");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getBodyID() {
		return bodyID;
	}
}
