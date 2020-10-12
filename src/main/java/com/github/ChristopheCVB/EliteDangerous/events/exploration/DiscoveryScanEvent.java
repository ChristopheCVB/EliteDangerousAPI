package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class DiscoveryScanEvent extends Event {
	public Long systemAddress;
	public Integer body;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onDiscoveryScanEventTriggered((DiscoveryScanEvent) event);
		}

		void onDiscoveryScanEventTriggered(DiscoveryScanEvent discoveryScanEvent);
	}
}
