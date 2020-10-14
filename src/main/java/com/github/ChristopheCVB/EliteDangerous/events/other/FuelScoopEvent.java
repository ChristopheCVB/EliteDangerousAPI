package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FuelScoopEvent extends Event {
    public Float scooped;
    public Integer total;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFuelScoopEventTriggered((FuelScoopEvent) event);
        }

        void onFuelScoopEventTriggered(FuelScoopEvent fuelScoopEvent);
    }
}
