package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class LiftoffEvent extends Event {
	
	private Boolean playerControlled;
	private Double longitude, latitude;
	
	public LiftoffEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.playerControlled = JsonUtils.pullBoolean(jsonEvent, "PlayerControlled");
        this.longitude = playerControlled ? JsonUtils.pullDouble(jsonEvent, "Longitude") : null;
        this.latitude = playerControlled ? JsonUtils.pullDouble(jsonEvent, "Latitude") : null;

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Boolean getPlayerControlled() {
		return playerControlled;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getLatitude() {
		return latitude;
	}
	
}
