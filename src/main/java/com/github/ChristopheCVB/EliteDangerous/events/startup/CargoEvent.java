package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.CargoInventory;

import java.util.List;

public class CargoEvent extends Event {
	public String vessel;
	public Integer count;
	public List<CargoInventory> inventory;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onCargoEventTriggered((CargoEvent) event);
		}

		void onCargoEventTriggered(CargoEvent cargoEvent);
	}
}
