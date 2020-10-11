package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.ModuleItem;

import java.util.ArrayList;

public class MassModuleStoreEvent extends Event {
	public Long marketID;
	public String ship;
	public Integer shipID;
	public ArrayList<ModuleItem> items;
}
