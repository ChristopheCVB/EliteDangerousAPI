package com.github.ChristopheCVB.EliteDangerous.events.models.shiptargeted;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;

public class ShipScanStage2 extends ShipScanStage1 implements ScanStageInfo {
	
	private Double shieldHealth, hullHealth;


	public ShipScanStage2(Boolean targetLocked, String ship, Integer scanStage, String pilotName,
			String pilotNameLocalised, String pilotRank, String shipLocalised, String power, Double shieldHealth,
			Double hullHealth) {
		super(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power);
		this.shieldHealth = shieldHealth;
		this.hullHealth = hullHealth;
	}

	public Double getShieldHealth() {
		return shieldHealth;
	}

	public Double getHullHealth() {
		return hullHealth;
	}

}
