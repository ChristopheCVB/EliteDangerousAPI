package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierShipPackEvent extends Event {
    public Long carrierID;
    public String operation;
    public String packTheme;
    public Integer packTier;
    public Integer cost;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierShipPackEventTriggered((CarrierShipPackEvent) event);
        }

        void onCarrierShipPackEventTriggered(CarrierShipPackEvent carrierJumpEvent);
    }
}
