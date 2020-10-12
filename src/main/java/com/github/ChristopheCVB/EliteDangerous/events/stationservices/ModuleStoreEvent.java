package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleStoreEvent extends Event {
	public String slot;
	public String storedItem;
	public String storedItemLocalised;
	public String ship;
	public Integer shipID;
	public Boolean hot;
	public Long marketID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onModuleStoreEventTriggered((ModuleStoreEvent) event);
		}

		void onModuleStoreEventTriggered(ModuleStoreEvent moduleStoreEvent);
	}
}
