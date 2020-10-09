package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MiningRefinedEvent extends Event {
	
	private String type, typeLocalised;

	public MiningRefinedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.typeLocalised = JsonUtils.pullString(jsonEvent, "Type_Localised");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

}
