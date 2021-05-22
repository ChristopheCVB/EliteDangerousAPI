package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class PayBountiesEvent extends Event {
    public Long amount;
    public String faction, factionLocalised;
    public Integer shipID, brokerPercentage;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPayBountiesEventTriggered((PayBountiesEvent) event);
        }

        void onPayBountiesEventTriggered(PayBountiesEvent payBountiesEvent);
    }
}
