package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Killer;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DiedByWingEvent extends DiedEvent {
	@SerializedName("Killers")
	public ArrayList<Killer> killers;

	public DiedByWingEvent(String timestamp) {
        super(timestamp);
    }
}
