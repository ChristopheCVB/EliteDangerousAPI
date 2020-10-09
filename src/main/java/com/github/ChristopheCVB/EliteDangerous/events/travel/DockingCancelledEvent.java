package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.JsonObject;

public class DockingCancelledEvent extends Event {
	
	public DockingCancelledEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

}
