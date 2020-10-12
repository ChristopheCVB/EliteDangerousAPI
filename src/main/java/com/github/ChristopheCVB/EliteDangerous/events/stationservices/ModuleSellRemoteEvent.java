package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleSellRemoteEvent extends Event {
	public Integer storageSlot, shipID;
	public String sellItem;
	public String sellItemLocalised;
	public String ship;
	public Long serverID, sellPrice;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onModuleSellRemoteEventTriggered((ModuleSellRemoteEvent) event);
		}

		void onModuleSellRemoteEventTriggered(ModuleSellRemoteEvent moduleSellRemoteEvent);
	}
}
