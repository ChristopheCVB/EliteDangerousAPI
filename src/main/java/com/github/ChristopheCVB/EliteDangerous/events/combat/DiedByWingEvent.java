package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Killer;

import java.util.ArrayList;

public class DiedByWingEvent extends DiedEvent {
	public ArrayList<Killer> killers;

	public DiedByWingEvent(String timestamp) {
        super(timestamp);
    }
}
