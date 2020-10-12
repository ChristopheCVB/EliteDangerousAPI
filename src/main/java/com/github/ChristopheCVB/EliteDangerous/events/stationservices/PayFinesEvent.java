package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

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
