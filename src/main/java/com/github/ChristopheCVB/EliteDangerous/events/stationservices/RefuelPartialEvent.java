/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:44
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.JsonObject;

public class RefuelPartialEvent extends Event {

	/**
	 * !!Experimental!! This event will throw and Exception since I am missing the event data only use if you want to help me complete this Event.
	 * Send the Unused Event data to Discord => XenoPyax#5647  OR Mail to => xeno.pyax@gmail.com
	 *
	 * @param timestamp String
	 * @param jsonEvent JsonObject
	 */
	public RefuelPartialEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
	}

}
