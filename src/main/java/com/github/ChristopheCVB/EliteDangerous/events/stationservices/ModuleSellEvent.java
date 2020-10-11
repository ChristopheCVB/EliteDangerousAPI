package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleSellEvent extends Event {
	public String slot;
	public String sellItem;
	public String sellItemLocalised;
	public String ship;
	public Long sellPrice, marketID;
	public Integer shipID;
}
