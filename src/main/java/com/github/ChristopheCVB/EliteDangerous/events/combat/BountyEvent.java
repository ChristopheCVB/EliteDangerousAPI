package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public abstract class BountyEvent extends Event {
	public String target;
	public String victimFaction;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onBountyEventTriggered((BountyEvent) event);
		}

		void onBountyEventTriggered(BountyEvent bountyEvent);
	}
}
