package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

public class ShipTargettedStage1Event extends ShipTargettedStage0Event {
    public String pilotName;
    public String pilotNameLocalised;
    public String pilotRank;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipTargettedStage1EventTriggered((ShipTargettedStage1Event) event);
        }

        void onShipTargettedStage1EventTriggered(ShipTargettedStage1Event shipTargettedStage1Event);
    }
}
