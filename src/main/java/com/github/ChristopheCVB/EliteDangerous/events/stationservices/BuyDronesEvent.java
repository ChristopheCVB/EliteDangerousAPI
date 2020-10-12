package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyDronesEvent extends Event {
    public Integer count;
    public Integer buyPrice;
    public Integer totalCost;
    public String type;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onBuyDronesEventTriggered((BuyDronesEvent) event);
        }

        void onBuyDronesEventTriggered(BuyDronesEvent buyDronesEvent);
    }
}
