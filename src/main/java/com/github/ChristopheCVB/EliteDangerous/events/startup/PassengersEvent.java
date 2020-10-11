package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.PassengerManifest;

import java.util.ArrayList;

public class PassengersEvent extends Event {
	public ArrayList<PassengerManifest> manifest;
}
