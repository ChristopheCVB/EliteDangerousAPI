package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StationEconomy;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class DockedEvent extends Event {
	
	private String stationName, stationType, starSystem, stationFactionName, stationFactionState, stationGovernment, stationGovernmentLocalised, stationAllegiance, stationEconomy,
	stationEconomyLocalised;
	private List<StationEconomy> stationEconomies;
	private Long systemAddress, marketID;
	private Double distanceFromStarLS;
	private Boolean activeFine;
	private List<String> stationServices;
	
	public DockedEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		JsonObject stationFaction = JsonUtils.pullJsonObject(jsonEvent, "StationFaction");

        this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
        this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.stationFactionName = JsonUtils.pullString(stationFaction, "Name");
        this.stationFactionState = JsonUtils.pullString(stationFaction, "FactionState");
        this.stationGovernment = JsonUtils.pullString(jsonEvent, "StationGovernment");
        this.stationGovernmentLocalised = JsonUtils.pullString(jsonEvent, "StationGovernment_Localised");
        this.stationAllegiance = JsonUtils.pullString(jsonEvent, "StationAllegiance");
        this.stationEconomy = JsonUtils.pullString(jsonEvent, "StationEconomy");
        this.stationEconomyLocalised = JsonUtils.pullString(jsonEvent, "StationEconomy_Localised");
        this.stationEconomies = GameFilesUtils.createStationEconomiesList(JsonUtils.pullJsonArray(jsonEvent, "StationEconomies"));
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.distanceFromStarLS = JsonUtils.pullDouble(jsonEvent, "DistFromStarLS");
        this.stationServices = GameFilesUtils.createStationServiceList(JsonUtils.pullJsonArray(jsonEvent, "StationServices"));
        this.activeFine = JsonUtils.pullBoolean(jsonEvent, "ActiveFine");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public String getStationFactionName() {
		return stationFactionName;
	}

	public String getStationFactionState() {
		return stationFactionState;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public List<StationEconomy> getStationEconomies() {
		return stationEconomies;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getMarketID() {
		return marketID;
	}

	public Double getDistanceFromStarLS() {
		return distanceFromStarLS;
	}

	public Boolean getActiveFine() {
		return activeFine;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

}
