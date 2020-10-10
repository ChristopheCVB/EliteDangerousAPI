package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.market.MarketFile;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MarketEvent extends Event {
	// TODO: Chris can you do this file?
	public String stationName;
	public String starSystem;
	public String stationType;
	public String carrierDockingAccess;
	public Integer marketID;
	public MarketFile marketFile;
	
	public MarketEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
		this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
		this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
		this.marketID = JsonUtils.pullInt(jsonEvent, "MarketID");
		this.carrierDockingAccess = JsonUtils.pullString(jsonEvent, "CarrierDockingAccess");
		this.marketFile = new MarketFile();

		GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Integer getMarketID() {
		return marketID;
	}

	public MarketFile getMarketFile() {
		return marketFile;
	}

	public String getStationType() {
		return stationType;
	}

	public String getCarrierDockingAccess() {
		return carrierDockingAccess;
	}

}
