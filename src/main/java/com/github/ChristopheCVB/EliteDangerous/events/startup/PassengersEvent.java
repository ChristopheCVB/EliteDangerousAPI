package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.PassengerManifest;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class PassengersEvent extends Event {
	
	private List<PassengerManifest> passengers;

	public PassengersEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.passengers = GameFilesUtils.createPassengerManifest(JsonUtils.pullJsonArray(jsonEvent, "Manifest"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public List<PassengerManifest> getPassengers() {
		return passengers;
	}

}
