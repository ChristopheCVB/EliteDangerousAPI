package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShieldStateEvent extends Event {
	
	private Boolean shieldsUp;

	public ShieldStateEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.shieldsUp = JsonUtils.pullBoolean(jsonEvent, "ShieldsUp");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Boolean isShieldsUp() {
		return shieldsUp;
	}

}
