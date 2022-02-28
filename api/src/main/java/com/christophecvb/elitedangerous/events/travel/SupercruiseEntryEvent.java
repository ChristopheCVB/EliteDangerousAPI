package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class SupercruiseEntryEvent extends Event {
	public String starSystem;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onSupercruiseEntryEventTriggered((SupercruiseEntryEvent) event);
		}

		void onSupercruiseEntryEventTriggered(SupercruiseEntryEvent supercruiseEntryEvent);
	}
}
