package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SupercruiseEntryEvent extends Event {
	public String starSystem;
	public Long systemAddress;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onSupercruiseEntryEventTriggered((SupercruiseEntryEvent) event);
		}

		void onSupercruiseEntryEventTriggered(SupercruiseEntryEvent supercruiseEntryEvent);
	}
}
