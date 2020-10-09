package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SAAScanCompleteEvent extends Event {
	
	private String bodyName;
	private Integer bodyID, probesUsed, efficiencyTarget;
	private Long systemAddress;
	
	public SAAScanCompleteEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.bodyName = JsonUtils.pullString(jsonEvent, "BodyName");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");
        this.probesUsed = JsonUtils.pullInt(jsonEvent, "ProbesUsed");
        this.efficiencyTarget = JsonUtils.pullInt(jsonEvent, "EfficiencyTarget");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getBodyName() {
		return bodyName;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Integer getProbesUsed() {
		return probesUsed;
	}

	public Integer getEfficiencyTarget() {
		return efficiencyTarget;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
