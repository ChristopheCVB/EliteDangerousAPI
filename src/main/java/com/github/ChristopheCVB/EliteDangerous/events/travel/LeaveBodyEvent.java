package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class LeaveBodyEvent extends Event {

	private String starSystem, body;
	private Long systemAdress;
	private Integer bodyID;
	
	public LeaveBodyEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.body = JsonUtils.pullString(jsonEvent, "Body");
        this.systemAdress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStarSystem() {
		return starSystem;
	}

	public String getBody() {
		return body;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Integer getBodyID() {
		return bodyID;
	}

}
