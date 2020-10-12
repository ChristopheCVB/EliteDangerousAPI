package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Killer;

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
