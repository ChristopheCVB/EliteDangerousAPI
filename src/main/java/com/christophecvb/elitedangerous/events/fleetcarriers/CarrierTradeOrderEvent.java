package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierTradeOrderEvent extends Event {
    public Long carrierID;
    public Boolean blackMarket;
    public String commodity;
    public Integer purchaseOrder;
    public Integer saleOrder;
    public Boolean cancelTrade;
    public Integer price;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierTradeOrderEventTriggered((CarrierTradeOrderEvent) event);
        }

        void onCarrierTradeOrderEventTriggered(CarrierTradeOrderEvent carrierTradeOrderEvent);
    }
}
