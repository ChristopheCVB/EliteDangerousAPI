/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 07:15
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class SetUserShipNameEvent extends Event {
	
	private String ship;
	private Integer shipId;
	private String userShipName, userShipId;
	
	public SetUserShipNameEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.ship = JsonUtils.pullString(jsonEvent, "Ship");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.userShipName = JsonUtils.pullString(jsonEvent, "UserShipName");
        this.userShipId = JsonUtils.pullString(jsonEvent, "UserShipId");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShip() {
		return ship;
	}

	public Integer getShipId() {
		return shipId;
	}

	public String getUserShipName() {
		return userShipName;
	}

	public String getUserShipId() {
		return userShipId;
	}

}
