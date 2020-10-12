package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SellDronesEvent extends Event {
    public String type;
    public Integer count;
    public Long sellPrice, totalSale;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSellDronesEventTriggered((SellDronesEvent) event);
        }

        void onSellDronesEventTriggered(SellDronesEvent sellDronesEvent);
    }
}
