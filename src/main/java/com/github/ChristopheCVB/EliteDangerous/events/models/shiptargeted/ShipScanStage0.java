package com.github.ChristopheCVB.EliteDangerous.events.models.shiptargeted;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;

public class ShipScanStage0 implements ScanStageInfo {
	
	private Boolean targetLocked;
	private String ship;
	private Integer scanStage;
	
	public ShipScanStage0(Boolean targetLocked, String ship, Integer scanStage) {
		this.targetLocked = targetLocked;
		this.ship = ship;
		this.scanStage = scanStage;
	}

	public Boolean getTargetLocked() {
		return targetLocked;
	}

	public String getShip() {
		return ship;
	}

	public Integer getScanStage() {
		return scanStage;
	}
	
}
