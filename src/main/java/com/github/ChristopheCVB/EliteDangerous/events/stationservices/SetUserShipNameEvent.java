package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SetUserShipNameEvent extends Event {
	public String ship;
	public Integer shipID;
	public String userShipName, userShipId;
	
	public SetUserShipNameEvent(String timestamp) {
        super(timestamp);
    }
}
