package com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;

public class ShipScanStage1 extends ShipScanStage0 implements ScanStageInfo {
	
	private String pilotName, pilotNameLocalised, pilotRank, shipLocalised, power;

	public ShipScanStage1(Boolean targetLocked, String ship, Integer scanStage, String pilotName,
			String pilotNameLocalised, String pilotRank, String shipLocalised, String power) {
		super(targetLocked, ship, scanStage);
		this.pilotName = pilotName;
		this.pilotNameLocalised = pilotNameLocalised;
		this.pilotRank = pilotRank;
		this.shipLocalised = shipLocalised;
		this.power = power;
	}

	public String getPilotName() {
		return pilotName;
	}

	public String getPilotNameLocalised() {
		return pilotNameLocalised;
	}

	public String getPilotRank() {
		return pilotRank;
	}

	public String getShipLocalised() {
		return shipLocalised;
	}

	public String getPower() {
		return power;
	}
	
}
