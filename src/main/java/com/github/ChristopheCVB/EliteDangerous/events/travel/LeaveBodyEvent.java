package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LeaveBodyEvent extends Event {
	public String starSystem, body;
	public Long systemAddress;
	public Integer bodyID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onLeaveBodyEventTriggered((LeaveBodyEvent) event);
		}

		void onLeaveBodyEventTriggered(LeaveBodyEvent leaveBodyEvent);
	}
}
