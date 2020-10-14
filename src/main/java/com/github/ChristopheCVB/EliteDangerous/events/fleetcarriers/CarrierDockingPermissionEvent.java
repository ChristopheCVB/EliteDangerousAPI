package com.github.ChristopheCVB.EliteDangerous.events.fleetcarriers;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierDockingPermissionEvent extends Event {
    public Long carrierID;
    public String dockingAccess;
    public Boolean allowNotorious;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCarrierDockingPermissionEventTriggered((CarrierDockingPermissionEvent) event);
        }

        void onCarrierDockingPermissionEventTriggered(CarrierDockingPermissionEvent carrierDockingPermissionEvent);
    }
}
