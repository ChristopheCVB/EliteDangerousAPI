package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CarrierCrewServicesEvent extends Event{

	private String crewName, crewRole, operation;
	private Long carrierId;
	
	public CarrierCrewServicesEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.crewName = JsonUtils.pullString(jsonEvent, "CrewName");
        this.crewRole = JsonUtils.pullString(jsonEvent, "CrewRole");
        this.operation = JsonUtils.pullString(jsonEvent, "Operation");
        this.carrierId = JsonUtils.pullLong(jsonEvent, "CarrierID");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getCrewName() {
		return crewName;
	}

	public String getCrewRole() {
		return crewRole;
	}

	public String getOperation() {
		return operation;
	}

	public Long getCarrierId() {
		return carrierId;
	}
	
}
