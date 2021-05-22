package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ShipyardBuyEvent extends Event {
	public String shipType, sellOldShip;
	public Long shipPrice, sellPrice;
	public Integer sellShipID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onShipyardBuyEventTriggered((ShipyardBuyEvent) event);
		}

		void onShipyardBuyEventTriggered(ShipyardBuyEvent shipyardBuyEvent);
	}
}
