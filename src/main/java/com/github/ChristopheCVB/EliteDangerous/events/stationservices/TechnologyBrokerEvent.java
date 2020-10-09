/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 11:15
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.JsonObject;

public class TechnologyBrokerEvent extends Event {
	
	public TechnologyBrokerEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

}
