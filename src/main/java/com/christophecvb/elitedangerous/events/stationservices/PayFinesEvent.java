package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class PayFinesEvent extends Event {
    public Long amount;
    public Integer shipID;
    public Boolean allFines;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onPayFinesEventTriggered((PayFinesEvent) event);
        }

        void onPayFinesEventTriggered(PayFinesEvent payFinesEvent);
    }
}
