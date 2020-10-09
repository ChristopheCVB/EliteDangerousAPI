package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class TouchdownEvent extends Event {
	
	private Boolean playerControlled;
	private Double latitude, longitude;
	
	public TouchdownEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.playerControlled = JsonUtils.pullBoolean(jsonEvent, "PlayerControlled");
        this.latitude = playerControlled ? JsonUtils.pullDouble(jsonEvent, "Latitude") : null;
        this.longitude = playerControlled ? JsonUtils.pullDouble(jsonEvent, "Longitude") : null;

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Boolean getPlayerControlled() {
		return playerControlled;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

}
