package com.github.ChristopheCVB.EliteDangerous.events;

import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;

public abstract class Event {
	long timestamp;

	public Event(String timestamp) {
		this.timestamp = GameFilesUtils.getTimeMillis(timestamp);
	}

	/**
	 * @return String Date & Time as String formatted E.g
	 * {@literal} <b>12 Apr 2019</b>
	 */
	public String getTimestampFormatted() {
		return GameFilesUtils.getFormattedDate(this.timestamp);
	}

	/**
	 * @return timestamp time in milliseconds
	 */
	public long getTimestamp() {
		return timestamp;
	}

	public interface Listener {
		void onTriggered(Event event);
	}
}
