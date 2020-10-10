package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage0;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage1;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage2;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage3;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;
import com.google.gson.annotations.SerializedName;

public class ShipTargetedEvent extends Event {
    public Integer scanStage;
    public Boolean targetLocked;
    public String ship;
    @SerializedName("Ship_Localised")
    public String shipLocalised;
    public String pilotName;
    @SerializedName("PilotName_Localised")
    public String pilotNameLocalised;
    public String pilotRank, faction, legalStatus, power;
    public Double shieldHealth, hullHealth;
    public Long bounty;

    public ShipTargetedEvent(String timestamp) {
        super(timestamp);
    }

    public ScanStageInfo getScanStageInfo() {
    	ScanStageInfo scanStageInfo = null;

    	switch (this.scanStage) {
			case 0:
				scanStageInfo = new ShipScanStage0(targetLocked, ship, scanStage);
				break;

			case 1:
				scanStageInfo = new ShipScanStage1(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power);
				break;

			case 2:
				scanStageInfo = new ShipScanStage2(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth);
				break;

			case 3:
				scanStageInfo = new ShipScanStage3(targetLocked, ship, scanStage, pilotName, pilotNameLocalised, pilotRank, shipLocalised, power, shieldHealth, hullHealth, faction, legalStatus, bounty);
				break;
		}

        return scanStageInfo;
    }

}
