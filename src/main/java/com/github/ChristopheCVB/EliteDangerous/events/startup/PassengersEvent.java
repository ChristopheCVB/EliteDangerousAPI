package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.PassengerManifest;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class PassengersEvent extends Event {
	public ArrayList<PassengerManifest> manifest;

	public PassengersEvent(String timestamp) {
        super(timestamp);
    }
}
