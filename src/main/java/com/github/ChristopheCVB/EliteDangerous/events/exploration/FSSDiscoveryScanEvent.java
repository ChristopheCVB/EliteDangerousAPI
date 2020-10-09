package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class FSSDiscoveryScanEvent extends Event {
	
	private String systemName;
	private Long systemAddress;
	private Double progress;
	private Integer bodyCount, nonBodyCount;
	
	public FSSDiscoveryScanEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.systemName = JsonUtils.pullString(jsonEvent, "SystemName");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.progress = JsonUtils.pullDouble(jsonEvent, "Progress");
        this.bodyCount = JsonUtils.pullInt(jsonEvent, "BodyCount");
        this.nonBodyCount = JsonUtils.pullInt(jsonEvent, "NonBodyCount");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Double getProgress() {
		return progress;
	}

	public Integer getBodyCount() {
		return bodyCount;
	}

	public Integer getNonBodyCount() {
		return nonBodyCount;
	}
	
	public String getSystemName() {
		return systemName;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

}
