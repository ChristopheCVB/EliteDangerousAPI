package com.christophecvb.elitedangerous.events.combat;

import com.christophecvb.elitedangerous.events.Event;

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
