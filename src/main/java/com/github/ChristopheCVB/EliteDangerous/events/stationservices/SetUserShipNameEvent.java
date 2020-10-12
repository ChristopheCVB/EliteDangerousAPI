package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SetUserShipNameEvent extends Event {
    public String ship;
    public Integer shipID;
    public String userShipName, userShipId;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSetUserShipNameEventTriggered((SetUserShipNameEvent) event);
        }

        void onSetUserShipNameEventTriggered(SetUserShipNameEvent setUserShipNameEvent);
    }
}
