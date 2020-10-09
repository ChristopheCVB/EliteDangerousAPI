package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class DockingRequestedEvent extends Event {
	
	private String stationmName, stationType;
	private Long marketID;
	
	public DockingRequestedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.stationmName = JsonUtils.pullString(jsonEvent, "StationName");
        this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStationmName() {
		return stationmName;
	}

	public String getStationType() {
		return stationType;
	}

	public Long getMarketID() {
		return marketID;
	}

}
