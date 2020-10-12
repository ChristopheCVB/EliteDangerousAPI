package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class UndockedEvent extends Event {
	public String stationName, stationType;
	public Long marketID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onUndockedEventTriggered((UndockedEvent) event);
		}

		void onUndockedEventTriggered(UndockedEvent undockedEvent);
	}
}
