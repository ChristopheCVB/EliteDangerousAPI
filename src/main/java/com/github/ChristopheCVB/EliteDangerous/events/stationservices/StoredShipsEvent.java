package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.StoredShipHere;
import com.github.ChristopheCVB.EliteDangerous.events.models.StoredShipRemote;

import java.util.List;

public class StoredShipsEvent extends Event {
	public String stationName, starSystem;
	public Long marketID;
	public List<StoredShipHere> shipsHere;
	public List<StoredShipRemote> shipsRemote;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onStoredShipsEventTriggered((StoredShipsEvent) event);
		}

		void onStoredShipsEventTriggered(StoredShipsEvent storedShipsEvent);
	}
}
