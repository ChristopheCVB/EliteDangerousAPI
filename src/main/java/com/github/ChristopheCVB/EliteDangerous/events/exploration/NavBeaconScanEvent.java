package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class NavBeaconScanEvent extends Event {
	
	private Long systemAddress;
	private Integer numBodies;
	
	public NavBeaconScanEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.numBodies = JsonUtils.pullInt(jsonEvent, "NumBodies");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Integer getNumBodies() {
		return numBodies;
	}

}
