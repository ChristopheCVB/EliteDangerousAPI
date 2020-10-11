package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PayFinesEvent extends Event {
	public Long amount;
	public Integer shipID;
	public Boolean allFines;
}
