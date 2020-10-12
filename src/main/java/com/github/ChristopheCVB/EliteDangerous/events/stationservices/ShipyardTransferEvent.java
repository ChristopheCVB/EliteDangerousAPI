package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ShipyardTransferEvent extends Event {
    public String shipType, shipTypeLocalised, system;
    public Integer shipID;
    public Long shipMarketID, transferPrice, transferTime, marketID;
    public Double distance;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipyardTransferEventTriggered((ShipyardTransferEvent) event);
        }

        void onShipyardTransferEventTriggered(ShipyardTransferEvent shipyardTransferEvent);
    }
}
