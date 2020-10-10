package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Mission;

import java.util.ArrayList;

public class MissionsEvent extends Event {
	public ArrayList<Mission> active;
	public ArrayList<Mission> failed;
	public ArrayList<Mission> complete;
	
	public MissionsEvent(String timestamp) {
        super(timestamp);
    }
}
