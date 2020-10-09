package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ScreenshotEvent extends Event {
	
	private String filename, system, body;
	private Integer width, height, heading;
	private Double latitude, longitude, altitude;
	
	public ScreenshotEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.filename = JsonUtils.pullString(jsonEvent, "Filename");
        this.system = JsonUtils.pullString(jsonEvent, "System");
        this.body = JsonUtils.pullString(jsonEvent, "Body");
        this.width = JsonUtils.pullInt(jsonEvent, "Width");
        this.height = JsonUtils.pullInt(jsonEvent, "Height");
        this.heading = JsonUtils.pullInt(jsonEvent, "Heading");
        this.latitude = JsonUtils.pullDouble(jsonEvent, "Latitude");
        this.longitude = JsonUtils.pullDouble(jsonEvent, "Longitude");
        this.altitude = JsonUtils.pullDouble(jsonEvent, "Altitude");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getFilename() {
		return filename;
	}

	public String getSystem() {
		return system;
	}

	public String getBody() {
		return body;
	}

	public Integer getWidth() {
		return width;
	}

	public Integer getHeight() {
		return height;
	}

	public Integer getHeading() {
		return heading;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Double getAltitude() {
		return altitude;
	}

}
