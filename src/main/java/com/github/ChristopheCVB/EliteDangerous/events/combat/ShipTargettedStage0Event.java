package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipTargettedStage0Event extends ShipTargettedEvent {
    public String ship;
    public String shipLocalised;
    public Integer scanStage;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipTargettedStage0EventTriggered((ShipTargettedStage0Event) event);
        }

        void onShipTargettedStage0EventTriggered(ShipTargettedStage0Event shipTargettedStage0Event);
    }
}
