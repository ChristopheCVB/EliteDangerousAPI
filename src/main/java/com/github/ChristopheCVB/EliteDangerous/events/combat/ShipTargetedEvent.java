package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage0;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage1;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage2;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.shiptargeted.ShipScanStage3;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanStageInfo;

public class ShipTargetedEvent extends Event {
    public Integer scanStage;
    public Boolean targetLocked;
    public String ship;
    public String shipLocalised;
    public String pilotName;
    public String pilotNameLocalised;
    public String pilotRank, faction, legalStatus, power;
    public Double shieldHealth, hullHealth;
    public Long bounty;

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

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipTargetedEventTriggered((ShipTargetedEvent) event);
        }

        void onShipTargetedEventTriggered(ShipTargetedEvent shipTargetedEvent);
    }
}
