package com.github.ChristopheCVB.EliteDangerous.events;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public abstract class Event {
	public Date timestamp;
	@SerializedName("event")
	public String type;

	public Event(String timestamp) {
		this.timestamp = new Date(GameFilesUtils.getTimeMillis(timestamp));
	}

	public interface Listener {
		void onTriggered(Event event);
	}
}
