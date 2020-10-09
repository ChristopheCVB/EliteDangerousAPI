package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class DockingDeniedEvent extends Event {

	private String reason, stationName, stationType;
	private Long marketID;
	
	public DockingDeniedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.reason = JsonUtils.pullString(jsonEvent, "Reason");
        this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
        this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getReason() {
		return reason;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public Long getMarketID() {
		return marketID;
	}

}
