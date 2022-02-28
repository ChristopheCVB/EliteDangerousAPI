package com.christophecvb.elitedangerous.events.trade;

import com.christophecvb.elitedangerous.events.Event;

public class AsteroidCrackedEvent extends Event {
	public String body;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onAsteroidCrackedEventTriggered((AsteroidCrackedEvent) event);
		}

		void onAsteroidCrackedEventTriggered(AsteroidCrackedEvent asteroidCrackedEvent);
	}
}
