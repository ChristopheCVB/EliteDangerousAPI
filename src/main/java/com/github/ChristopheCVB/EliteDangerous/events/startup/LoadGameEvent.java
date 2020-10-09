package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class LoadGameEvent extends Event {
	
	private String commander, FID, ship, shipLocalised, shipName, shipIdent, gameMode, group;
	private Integer shipId;
	private Double fuelLevel, fuelCapacity;
	private Long credits, loan;
	private Boolean horizons;
	
	public LoadGameEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.commander = JsonUtils.pullString(jsonEvent, "Commander");
		this.FID = JsonUtils.pullString(jsonEvent, "FID");
		this.ship = JsonUtils.pullString(jsonEvent, "Ship");
		this.shipLocalised = JsonUtils.pullString(jsonEvent, "Ship_Localised");
		this.shipName = JsonUtils.pullString(jsonEvent, "ShipName");
        this.shipIdent = JsonUtils.pullString(jsonEvent, "ShipIdent");
        this.gameMode = JsonUtils.pullString(jsonEvent, "GameMode");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.fuelLevel = JsonUtils.pullDouble(jsonEvent, "FuelLevel");
        this.fuelCapacity = JsonUtils.pullDouble(jsonEvent, "FuelCapacity");
        this.credits = JsonUtils.pullLong(jsonEvent, "Credits");
        this.loan = JsonUtils.pullLong(jsonEvent, "Loan");
        this.group = JsonUtils.pullString(jsonEvent, "Group");
        this.horizons = JsonUtils.pullBoolean(jsonEvent, "Horizons");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getCommander() {
		return commander;
	}

	public String getFID() {
		return FID;
	}

	public String getShip() {
		return ship;
	}

	public String getShipLocalised() {
		return shipLocalised;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipIdent() {
		return shipIdent;
	}

	public String getGameMode() {
		return gameMode;
	}

	public String getGroup() {
		return group;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Double getFuelLevel() {
		return fuelLevel;
	}

	public Double getFuelCapacity() {
		return fuelCapacity;
	}

	public Long getCredits() {
		return credits;
	}

	public Long getLoan() {
		return loan;
	}

	public Boolean getHorizons() {
		return horizons;
	}

}
