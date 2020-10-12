package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ApproachBodyEvent extends Event {
	public String starSystem;
	public String body;
	public Integer bodyID;
	public Long systemAddress;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onApproachBodyEventTriggered((ApproachBodyEvent) event);
		}

		void onApproachBodyEventTriggered(ApproachBodyEvent approachBodyEvent);
	}
}
