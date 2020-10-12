package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SellShipOnRebuyEvent extends Event {
    // TODO: Parse SellShipOnRebuyEvent Data
    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSellShipOnRebuyEventTriggered((SellShipOnRebuyEvent) event);
        }

        void onSellShipOnRebuyEventTriggered(SellShipOnRebuyEvent sellShipOnRebuyEvent);
    }
}
