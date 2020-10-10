package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredModule;

import java.util.List;

public class StoredModulesEvent extends Event {
	public Long marketID;
	public String stationName, starSystem;
	public List<StoredModule> items;

	public StoredModulesEvent(String timestamp) {
		super(timestamp);
	}
}
