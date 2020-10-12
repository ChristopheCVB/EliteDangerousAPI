package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class PvPKillEvent extends Event {
	public String victim;
	public Integer combatRank;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onPvPKillEventTriggered((PvPKillEvent) event);
		}

		void onPvPKillEventTriggered(PvPKillEvent pvpKillEvent);
	}
}
