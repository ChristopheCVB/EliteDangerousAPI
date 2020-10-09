package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Module;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class LoadoutEvent extends Event {
	
	private String ship, shipName, shipIdent;
	private Integer shipID, hullValue, moduleValue, rebuy, cargoCapcity, main;
	private Double hullHealth, maxJumpRange, reserve, unladenMass;
	private List<Module> modules;
	
	public LoadoutEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);
		JsonObject fuelCapacity = JsonUtils.pullJsonObject(jsonEvent, "FuelCapacity");

		this.ship = JsonUtils.pullString(jsonEvent, "Ship");
		this.shipName = JsonUtils.pullString(jsonEvent, "ShipName");
		this.shipIdent = JsonUtils.pullString(jsonEvent, "ShipIdent");
        this.shipID = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.hullValue = JsonUtils.pullInt(jsonEvent, "HullValue");
        this.moduleValue = JsonUtils.pullInt(jsonEvent, "ModulesValue");
        this.hullHealth = JsonUtils.pullDouble(jsonEvent, "HullHealth");
        this.rebuy = JsonUtils.pullInt(jsonEvent, "Rebuy");
        this.maxJumpRange = JsonUtils.pullDouble(jsonEvent, "MaxJumpRange");
        this.cargoCapcity = JsonUtils.pullInt(jsonEvent, "CargoCapacity");
        this.main = JsonUtils.pullInt(fuelCapacity, "Main");
        this.reserve = JsonUtils.pullDouble(fuelCapacity, "Reserve");
        this.unladenMass = JsonUtils.pullDouble(jsonEvent, "UnladenMass");
        this.modules = GameFilesUtils.createModuleList(JsonUtils.pullJsonArray(jsonEvent, "Modules"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShip() {
		return ship;
	}

	public String getShipName() {
		return shipName;
	}

	public String getShipIdent() {
		return shipIdent;
	}

	public Integer getShipID() {
		return shipID;
	}

	public Integer getHullValue() {
		return hullValue;
	}

	public Integer getModuleValue() {
		return moduleValue;
	}

	public Integer getRebuy() {
		return rebuy;
	}

	public Integer getCargoCapcity() {
		return cargoCapcity;
	}

	public Integer getMain() {
		return main;
	}

	public Double getHullHealth() {
		return hullHealth;
	}

	public Double getMaxJumpRange() {
		return maxJumpRange;
	}

	public Double getReserve() {
		return reserve;
	}

	public Double getUnladenMass() {
		return unladenMass;
	}

	public List<Module> getModules() {
		return modules;
	}

}
