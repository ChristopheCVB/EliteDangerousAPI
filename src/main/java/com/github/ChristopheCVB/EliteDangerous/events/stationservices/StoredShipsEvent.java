package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipHere;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StoredShipRemote;

import java.util.List;

public class StoredShipsEvent extends Event {
	public String stationName, starSystem;
	public Long marketID;
	public List<StoredShipHere> shipsHere;
	public List<StoredShipRemote> shipsRemote;
}
