/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/15/2020 11:47
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardNewEvent extends Event {
	
	private String shipType;
	private Integer newShipId;
	
	public ShipyardNewEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.shipType = JsonUtils.pullString(jsonEvent, "ShipType");
        this.newShipId = JsonUtils.pullInt(jsonEvent, "NewShipID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShipType() {
		return shipType;
	}

	public Integer getNewShipId() {
		return newShipId;
	}

}
