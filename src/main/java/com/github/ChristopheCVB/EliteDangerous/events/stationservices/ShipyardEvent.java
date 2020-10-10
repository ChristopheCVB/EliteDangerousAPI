package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardEvent extends Event {
	
	private Long marketId;
	private String stationName, starSystem;
	
	public ShipyardEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMarketId() {
		return marketId;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

}
