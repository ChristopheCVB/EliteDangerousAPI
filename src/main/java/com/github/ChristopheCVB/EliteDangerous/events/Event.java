package com.github.ChristopheCVB.EliteDangerous.events;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public abstract class Event {
	public Date timestamp;
	@SerializedName("event")
	public String type;

	public interface Listener {
		void onTriggered(Event event);
	}
}
