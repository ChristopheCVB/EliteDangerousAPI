package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargettedStage3Event extends ShipTargettedStage2Event {
    public String faction;
    public String legalStatus;
    public Long bounty;
    public String subSystem;
    public Double subSystemHealth;
    public String power;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipTargettedStage3EventTriggered((ShipTargettedStage3Event) event);
        }

        void onShipTargettedStage3EventTriggered(ShipTargettedStage3Event shipTargettedStage3Event);
    }
}
