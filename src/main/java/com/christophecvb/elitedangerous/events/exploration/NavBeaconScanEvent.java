package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class NavBeaconScanEvent extends Event {
    public Long systemAddress;
    public Integer numBodies;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onNavBeaconScanEventTriggered((NavBeaconScanEvent) event);
        }

        void onNavBeaconScanEventTriggered(NavBeaconScanEvent navBeaconScanEvent);
    }
}
