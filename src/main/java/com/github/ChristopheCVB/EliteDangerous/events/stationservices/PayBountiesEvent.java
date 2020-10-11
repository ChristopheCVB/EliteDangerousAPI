package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PayBountiesEvent extends Event {
	public Long amount;
	public String faction, factionLocalised;
	public Integer shipID, brokerPercentage;
}
