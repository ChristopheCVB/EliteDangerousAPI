package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleSwapEvent extends Event {
	public Long marketID;
	public String fromSlot, toSlot, fromItem, fromItemLocalised, toItem, toItemLocalised, ship;
	public Integer shipID;
}
