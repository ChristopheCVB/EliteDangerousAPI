package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DockingRequestedEvent extends Event {
	public String stationName;
	public String stationType;
	public Long marketID;
}
