package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SellShipOnRebuyEvent extends Event {
    public String shipType;
    public String system;
    public Integer sellShipId;
    public Long shipPrice;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSellShipOnRebuyEventTriggered((SellShipOnRebuyEvent) event);
        }

        void onSellShipOnRebuyEventTriggered(SellShipOnRebuyEvent sellShipOnRebuyEvent);
    }
}
