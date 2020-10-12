package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class SearchAndRescueEvent extends Event {
	public Long marketID, reward;
	public String name, nameLocalised;
	public Integer count;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onSearchAndRescueEventTriggered((SearchAndRescueEvent) event);
		}

		void onSearchAndRescueEventTriggered(SearchAndRescueEvent searchAndRescueEvent);
	}
}
