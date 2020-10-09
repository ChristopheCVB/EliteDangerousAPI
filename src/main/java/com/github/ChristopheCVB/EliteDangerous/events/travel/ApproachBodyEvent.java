package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ApproachBodyEvent extends Event {
	
	private String starSystem, body;
	private Integer bodyID;
	private Long systemAddress;
	
	public ApproachBodyEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.body = JsonUtils.pullString(jsonEvent, "Body");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
