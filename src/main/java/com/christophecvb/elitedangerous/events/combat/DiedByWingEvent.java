package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Killer;

import java.util.List;

public class DiedByWingEvent extends DiedEvent {
	public List<Killer> killers;

	public interface Listener extends DiedEvent.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onDiedByWingEventTriggered((DiedByWingEvent) event);
		}

		void onDiedByWingEventTriggered(DiedByWingEvent diedByWingEvent);
	}
}
