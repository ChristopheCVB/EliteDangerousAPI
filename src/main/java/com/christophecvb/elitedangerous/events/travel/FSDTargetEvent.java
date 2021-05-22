package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;

public class FSDTargetEvent extends Event {
	public String name;
	public String starClass;
	public Long systemAddress;
	public Integer remainingJumpsInRoute;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onFSDTargetEventTriggered((FSDTargetEvent) event);
		}

		void onFSDTargetEventTriggered(FSDTargetEvent fsdTargetEvent);
	}
}
