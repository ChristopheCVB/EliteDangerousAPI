package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.StoredModule;

import java.util.List;

public class StoredModulesEvent extends Event {
	public Long marketID;
	public String stationName, starSystem;
	public List<StoredModule> items;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onStoredModulesEventTriggered((StoredModulesEvent) event);
		}

		void onStoredModulesEventTriggered(StoredModulesEvent storedModulesEvent);
	}
}
