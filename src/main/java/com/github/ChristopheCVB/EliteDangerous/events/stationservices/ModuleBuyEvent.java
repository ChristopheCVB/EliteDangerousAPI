package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleBuyEvent extends Event {
	public String slot;
	public String storedItem;
	public String storedItemLocalised;
	public String buyItem;
	public String buyItemLocalised;
	public String ship;
	public String sellItem;
	public String sellItemLocalised;
	public Long buyPrice;
	public Long marketID;
	public Long sellPrice;
	public Integer shipID;
}
