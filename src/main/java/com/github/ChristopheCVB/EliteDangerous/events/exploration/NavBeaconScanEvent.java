package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class NavBeaconScanEvent extends Event {
	private Long systemAddress;
	private Integer numBodies;
	
	public NavBeaconScanEvent(String timestamp) {
        super(timestamp);
    }
}
