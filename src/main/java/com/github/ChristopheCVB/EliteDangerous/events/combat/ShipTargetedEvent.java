package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage0;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage1;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage2;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage3;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipTargetedEvent extends Event {

	private Integer scanStage;
	private Boolean targetLocked;
	private String ship, shipLocalised, pilotName, pilotNameLocalised, pilotRank, faction, legalStatus, power;
	private Double shieldHealth, hullHealth;
	private Long bounty;
	
	public ShipTargetedEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.scanStage = JsonUtils.pullInt(jsonEvent, "ScanStage");
		this.bounty = JsonUtils.pullLong(jsonEvent, "Bounty");
		this.targetLocked = JsonUtils.pullBoolean(jsonEvent, "TargetLocked");
        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.shipLocalised = JsonUtils.pullString(jsonEvent, "Ship_Localised");
        this.pilotName = JsonUtils.pullString(jsonEvent, "PilotName");
        this.pilotNameLocalised = JsonUtils.pullString(jsonEvent, "PilotName_Localised");
        this.pilotRank = JsonUtils.pullString(jsonEvent, "PilotRank");
        this.shieldHealth = JsonUtils.pullDouble(jsonEvent, "ShieldHealth");
        this.hullHealth = JsonUtils.pullDouble(jsonEvent, "HullHealth");
        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.legalStatus = JsonUtils.pullString(jsonEvent, "LegalStatus");
        this.power = JsonUtils.pullString(jsonEvent, "Power");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }
	
	public ScanStageInfo getScanStageInfo() {
		if(scanStage == 0) {
			return new ShipScanStage0(targetLocked, ship, scanStage);
	 	}else if(scanStage == 1) {
	 		return new ShipScanStage1(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power);
	 	}else if(scanStage == 2) {
			return new ShipScanStage2(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth);
		}else if(scanStage == 3) {
	 		return new ShipScanStage3(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth, faction, legalStatus, bounty);
	 	}
		return null;
	 }

}
