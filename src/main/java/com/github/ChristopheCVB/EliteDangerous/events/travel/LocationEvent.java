package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Faction;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StationEconomy;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class LocationEvent extends Event {
	
	private String starSystem, systemAllegiance, systemEconomy, systemEconomy_Localised, systemSecondEconomy, systemSecondEconomy_Localised, systemGovernment, systemGovernment_Localised,
	systemSecurity, systemSecurity_Localised, body, bodyType, systemFactionName, systemFactionState, powerplayState, stationName, stationType, stationEconomy, stationFactionName, stationFactionState,
	stationAllegiance, stationGovernment, stationEconomyLocalised, stationGovernmentLocalised;
	private Double[] starPos;
	private Long systemAddress, population, marketID;
	private Integer bodyID;
	private Boolean docked;
	private List<Faction> factions;
	private List<String> powers, stationServices;
	private List<StationEconomy> stationEconomies;
	
	public LocationEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		JsonObject systemFaction = JsonUtils.pullJsonObject(jsonEvent, "SystemFaction");
		JsonObject stationFaction = JsonUtils.pullJsonObject(jsonEvent, "StationFaction");

		this.stationName = JsonUtils.pullString(jsonEvent, "StationName");
		this.stationType = JsonUtils.pullString(jsonEvent, "StationType");
		this.stationEconomy = JsonUtils.pullString(jsonEvent, "StationEconomy");
		this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
		this.systemAllegiance = JsonUtils.pullString(jsonEvent, "SystemAllegiance");
		this.systemEconomy = JsonUtils.pullString(jsonEvent, "SystemEconomy");
		this.systemEconomy_Localised = JsonUtils.pullString(jsonEvent, "SystemEconomy_Localised");
		this.systemSecondEconomy = JsonUtils.pullString(jsonEvent, "SystemSecondEconomy");
		this.systemSecondEconomy_Localised = JsonUtils.pullString(jsonEvent, "SystemSecondEconomy_Localised");
        this.systemGovernment = JsonUtils.pullString(jsonEvent, "SystemGovernment");
        this.systemGovernment_Localised = JsonUtils.pullString(jsonEvent, "SystemGovernment_Localised");
        this.systemSecurity = JsonUtils.pullString(jsonEvent, "SystemSecurity");
        this.systemSecurity_Localised = JsonUtils.pullString(jsonEvent, "SystemSecurity_Localised");
        this.body = JsonUtils.pullString(jsonEvent, "Body");
        this.bodyType = JsonUtils.pullString(jsonEvent, "BodyType");
        this.stationFactionName = JsonUtils.pullString(stationFaction, "Name");
        this.stationFactionState = JsonUtils.pullString(stationFaction, "FactionState");
        this.systemFactionName = JsonUtils.pullString(systemFaction, "Name");
        this.systemFactionState = JsonUtils.pullString(systemFaction, "FactionState");
        this.factions = GameFilesUtils.createFactionsList(JsonUtils.pullJsonArray(jsonEvent, "Factions"));
        this.powerplayState = JsonUtils.pullString(jsonEvent, "PowerplayState");
        this.starPos = GameFilesUtils.createPositionArray(JsonUtils.pullJsonArray(jsonEvent, "StarPos"));
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.population = JsonUtils.pullLong(jsonEvent, "Population");
        this.marketID = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");
        this.docked = JsonUtils.pullBoolean(jsonEvent, "Docked");
        this.powers = GameFilesUtils.createPowersArray(JsonUtils.pullJsonArray(jsonEvent, "Powers"));
        this.stationServices = GameFilesUtils.createStationServiceList(JsonUtils.pullJsonArray(jsonEvent, "StationServices"));
        this.stationEconomies = GameFilesUtils.createStationEconomiesList(JsonUtils.pullJsonArray(jsonEvent, "StationEconomies"));
        this.stationAllegiance = JsonUtils.pullString(jsonEvent, "StationAllegiance");
        this.stationGovernment = JsonUtils.pullString(jsonEvent, "StationGovernment");
        this.stationEconomyLocalised = JsonUtils.pullString(jsonEvent, "StationEconomy_Localised");
        this.stationGovernmentLocalised = JsonUtils.pullString(jsonEvent, "StationGovernment_Localised");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getStarSystem() {
		return starSystem;
	}

	public String getSystemAllegiance() {
		return systemAllegiance;
	}

	public String getSystemEconomy() {
		return systemEconomy;
	}

	public String getSystemEconomy_Localised() {
		return systemEconomy_Localised;
	}

	public String getSystemSecondEconomy() {
		return systemSecondEconomy;
	}

	public String getSystemSecondEconomy_Localised() {
		return systemSecondEconomy_Localised;
	}

	public String getSystemGovernment() {
		return systemGovernment;
	}

	public String getSystemGovernment_Localised() {
		return systemGovernment_Localised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public String getSystemSecurity_Localised() {
		return systemSecurity_Localised;
	}

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getSystemFactionName() {
		return systemFactionName;
	}

	public String getSystemFactionState() {
		return systemFactionState;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public String getStationName() {
		return stationName;
	}

	public String getStationType() {
		return stationType;
	}

	public String getStationEconomy() {
		return stationEconomy;
	}

	public String getStationFactionName() {
		return stationFactionName;
	}

	public String getStationFactionState() {
		return stationFactionState;
	}

	public String getStationAllegiance() {
		return stationAllegiance;
	}

	public String getStationGovernment() {
		return stationGovernment;
	}

	public String getStationEconomyLocalised() {
		return stationEconomyLocalised;
	}

	public String getStationGovernmentLocalised() {
		return stationGovernmentLocalised;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getMarketID() {
		return marketID;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Boolean getDocked() {
		return docked;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public List<String> getPowers() {
		return powers;
	}

	public List<String> getStationServices() {
		return stationServices;
	}

	public List<StationEconomy> getStationEconomies() {
		return stationEconomies;
	}

}
