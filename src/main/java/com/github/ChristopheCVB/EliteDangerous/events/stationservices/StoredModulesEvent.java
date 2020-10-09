/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 12:34
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredModule;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class StoredModulesEvent extends Event {

	private Long marketId;
	private String stationName, starSystem;
	private List<StoredModule> moduleList;

	public StoredModulesEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
		this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
		this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
		this.moduleList = GameFilesUtils.createStoredModuleList(JsonUtils.pullJsonArray(jsonEvent, "Items"));

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

	public List<StoredModule> getModuleList() {
		return moduleList;
	}

}
