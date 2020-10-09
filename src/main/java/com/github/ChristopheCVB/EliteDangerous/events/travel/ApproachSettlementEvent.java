/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 06/27/2020 12:46
*/

package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ApproachSettlementEvent extends Event {
	
	private String name, bodyName;
	private Integer bodyId;
	private Double latitude, longitude;
	private Long marketId, systemaddress;
	
	public ApproachSettlementEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.bodyName = JsonUtils.pullString(jsonEvent, "BodyName");
        this.bodyId = JsonUtils.pullInt(jsonEvent, "BodyID");
        this.latitude = JsonUtils.pullDouble(jsonEvent, "Latitude");
        this.longitude = JsonUtils.pullDouble(jsonEvent, "Longitude");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.systemaddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getBodyName() {
		return bodyName;
	}

	public Integer getBodyId() {
		return bodyId;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Long getSystemaddress() {
		return systemaddress;
	}

}
