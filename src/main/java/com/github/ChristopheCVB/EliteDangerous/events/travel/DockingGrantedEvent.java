package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class DockingGrantedEvent extends Event {
	
	private String stationName, stationType;
	private Long marketID;
	private Integer landingPad;
	
	public DockingGrantedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
        this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.landingPad = JsonUtils.pullInt(jsonEvent, "LandingPad");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
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

	public Integer getLandingPad() {
		return landingPad;
	}

}
