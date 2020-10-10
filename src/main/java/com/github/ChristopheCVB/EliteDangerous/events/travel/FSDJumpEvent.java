package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Conflict;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Faction;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class FSDJumpEvent extends Event {
	
	public String starSystem;
	public String systemAllegiance;
	public String systemEconomy;
	@SerializedName("SystemEconomy_Localised")
	public String systemEconomyLocalised;
	public String systemSecondEconomy;
	@SerializedName("SystemSecondEconomy_Localised")
	public String systemSecondEconomyLocalised;
	public String systemGovernment;
	@SerializedName("SystemGovernment_Localised")
	public String systemGovernmentLocalised;
	public String systemSecurity;
	@SerializedName("SystemSecurity_Localised")
	public String systemSecurityLocalised;
	public String body;
	public String bodyType;
	public String powerplayState;
	public String systemfactionName;
	public String systemfactionState;
	public Long population;
	public Long systemAddress;
	public Long boostUsed;
	public Integer bodyId;
	public Double jumpDistance;
	public Double fuelUsed;
	public Double fuelLevel;
	public ArrayList<Faction> factions;
	public ArrayList<Conflict> conflicts;
	public Double[] starPos;
	public ArrayList<String> powers;
	
	public FSDJumpEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		JsonObject systemFaction = JsonUtils.pullJsonObject(jsonEvent, "SystemFaction");

		this.body = JsonUtils.pullString(jsonEvent, "Body");
		this.bodyId = JsonUtils.pullInt(jsonEvent, "BodyID");
		this.bodyType = JsonUtils.pullString(jsonEvent, "BodyType");
		this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
		this.systemAllegiance = JsonUtils.pullString(jsonEvent, "SystemAllegiance");
		this.systemEconomy = JsonUtils.pullString(jsonEvent, "SystemEconomy");
		this.systemEconomyLocalised = JsonUtils.pullString(jsonEvent, "SystemEconomy_Localised");
		this.systemSecondEconomy = JsonUtils.pullString(jsonEvent, "SystemSecondEconomy");
		this.systemSecondEconomy_Localised = JsonUtils.pullString(jsonEvent, "SystemSecondEconomy_Localised");
        this.systemGovernment = JsonUtils.pullString(jsonEvent, "SystemGovernment");
        this.systemGovernmentLocalised = JsonUtils.pullString(jsonEvent, "SystemGovernment_Localised");
        this.systemSecurity = JsonUtils.pullString(jsonEvent, "SystemSecurity");
        this.systemSecurityLocalised = JsonUtils.pullString(jsonEvent, "SystemSecurity_Localised");
        this.population = JsonUtils.pullLong(jsonEvent, "Population");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.jumpDistance = JsonUtils.pullDouble(jsonEvent, "JumpDist");
        this.fuelUsed = JsonUtils.pullDouble(jsonEvent, "FuelUsed");
        this.fuelLevel = JsonUtils.pullDouble(jsonEvent, "FuelLevel");
        this.boostUsed = JsonUtils.pullLong(jsonEvent, "BoostUsed");
        this.powers = GameFilesUtils.createPowersArray(JsonUtils.pullJsonArray(jsonEvent, "Powers"));
        this.systemfactionName = JsonUtils.pullString(systemFaction, "Name");
        this.systemfactionState = JsonUtils.pullString(systemFaction, "FactionState");
        this.starPos = GameFilesUtils.createPositionArray(JsonUtils.pullJsonArray(jsonEvent, "StarPos"));
        this.factions = GameFilesUtils.createFactionsList(JsonUtils.pullJsonArray(jsonEvent, "Factions"));
        this.conflict = GameFilesUtils.createConflict(JsonUtils.pullJsonArray(jsonEvent, "Conflicts"));
        this.powerplayState = JsonUtils.pullString(jsonEvent, "PowerplayState");

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

	public String getSystemEconomyLocalised() {
		return systemEconomyLocalised;
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

	public String getSystemGovernmentLocalised() {
		return systemGovernmentLocalised;
	}

	public String getSystemSecurity() {
		return systemSecurity;
	}

	public String getSystemSecurityLocalised() {
		return systemSecurityLocalised;
	}

	public String getBody() {
		return body;
	}

	public String getBodyType() {
		return bodyType;
	}

	public String getPowerplayState() {
		return powerplayState;
	}

	public String getSystemfactionName() {
		return systemfactionName;
	}

	public String getSystemfactionState() {
		return systemfactionState;
	}

	public Long getPopulation() {
		return population;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Long getBoostUsed() {
		return boostUsed;
	}

	public Integer getBodyId() {
		return bodyId;
	}

	public Double getJumpDistance() {
		return jumpDistance;
	}

	public Double getFuelUsed() {
		return fuelUsed;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public List<Faction> getFactions() {
		return factions;
	}

	public Conflict getConflict() {
		return conflict;
	}

	public Double[] getStarPos() {
		return starPos;
	}

	public List<String> getPowers() {
		return powers;
	}

}
