/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:46
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipHere;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipRemote;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class StoredShipsEvent extends Event {
	
	private String stationName, starSystem;
	private Long marketId;
	private List<StoredShipHere> shipsHere;
	private List<StoredShipRemote> shipsRemote;
	
	public StoredShipsEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.shipsHere = GameFilesUtils.createStoredShipsHereList(JsonUtils.pullJsonArray(jsonEvent, "ShipsHere"));
        this.shipsRemote = GameFilesUtils.createStoredShipsRemoteList(JsonUtils.pullJsonArray(jsonEvent, "ShipsRemote"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<StoredShipHere> getShipsHere() {
		return shipsHere;
	}

	public List<StoredShipRemote> getShipsRemote() {
		return shipsRemote;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Long getMarketId() {
		return marketId;
	}

}
