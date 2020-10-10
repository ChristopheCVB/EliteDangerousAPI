package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CarrierCrewServicesEvent extends Event{

	public String crewName;
	public String crewRole;
	public String operation;
	public Long carrierId;
	
	public CarrierCrewServicesEvent(String timestamp) {
        super(timestamp);
    }
}
