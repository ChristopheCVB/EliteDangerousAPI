package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.PassengerManifest;

import java.util.List;

public class PassengersEvent extends Event {
	public List<PassengerManifest> manifest;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onPassengersEventTriggered((PassengersEvent) event);
		}

		void onPassengersEventTriggered(PassengersEvent passengersEvent);
	}
}
