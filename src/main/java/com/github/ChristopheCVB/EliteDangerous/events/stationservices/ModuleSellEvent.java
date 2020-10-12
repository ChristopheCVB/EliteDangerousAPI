package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleSellEvent extends Event {
	public String slot;
	public String sellItem;
	public String sellItemLocalised;
	public String ship;
	public Long sellPrice, marketID;
	public Integer shipID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onModuleSellEventTriggered((ModuleSellEvent) event);
		}

		void onModuleSellEventTriggered(ModuleSellEvent moduleSellEvent);
	}
}
