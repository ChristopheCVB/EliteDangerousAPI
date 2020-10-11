package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DockingDeniedEvent extends Event {
	public String reason;
	public String stationName;
	public String stationType;
	public Long marketID;
}
