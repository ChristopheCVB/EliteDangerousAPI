package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class InterdictionEvent extends Event {
	public Boolean success, isPlayer;
	public String interdictor, faction, power;
	public Integer combatRank;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onInterdictionEventTriggered((InterdictionEvent) event);
		}

		void onInterdictionEventTriggered(InterdictionEvent interdictionEvent);
	}
}
