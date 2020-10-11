package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ScreenshotEvent extends Event {
	public String filename, system, body;
	public Integer width, height, heading;
	public Double latitude, longitude, altitude;
}
