package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ScreenshotEvent extends Event {
	private String filename, system, body;
	private Integer width, height, heading;
	private Double latitude, longitude, altitude;
	
	public ScreenshotEvent(String timestamp) {
		super(timestamp);
    }
}
