package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargettedStage2Event extends ShipTargettedStage1Event {
    public Double shieldHealth;
    public Double hullHealth;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipTargettedStage2EventTriggered((ShipTargettedStage2Event) event);
        }

        void onShipTargettedStage2EventTriggered(ShipTargettedStage2Event shipTargettedStage2Event);
    }
}
