package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.JsonObject;

public class HeatWarningEvent extends Event {

	public HeatWarningEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

}
