package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ModuleBuyEvent extends Event {
	public String slot;
	public String storedItem;
	public String storedItemLocalised;
	public String buyItem;
	public String buyItemLocalised;
	public String ship;
	public String sellItem;
	public String sellItemLocalised;
	public Long buyPrice;
	public Long marketID;
	public Long sellPrice;
	public Integer shipID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onModuleBuyEventTriggered((ModuleBuyEvent) event);
		}

		void onModuleBuyEventTriggered(ModuleBuyEvent moduleBuyEvent);
	}
}
