package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class FSSAllBodiesFoundEvent extends Event {
	
	private String systemName;
	private Long systemAddress;
	private Integer count;
	
	public FSSAllBodiesFoundEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.systemName = JsonUtils.pullString(jsonEvent, "SystemName");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSystemName() {
		return systemName;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getCount() {
		return count;
	}

}
