package com.christophecvb.elitedangerous.events.stationservices;

import com.christophecvb.elitedangerous.events.Event;

public class ShipyardNewEvent extends Event {
	public String shipType;
	public Integer newShipID;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onShipyardNewEventTriggered((ShipyardNewEvent) event);
		}

		void onShipyardNewEventTriggered(ShipyardNewEvent shipyardNewEvent);
	}
}
