package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class EjectCargoEvent extends Event {
	
	private String type, typeLocalised, powerplayOrigin;
	private Integer count;
	private Long missionID;
	private Boolean abondoned;
	
	public EjectCargoEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.typeLocalised = JsonUtils.pullString(jsonEvent, "Type_Localised");
        this.powerplayOrigin = JsonUtils.pullString(jsonEvent, "PowerplayOrigin");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.missionID = JsonUtils.pullLong(jsonEvent, "MissionID");
        this.abondoned = JsonUtils.pullBoolean(jsonEvent, "Abandoned");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public String getTypeLocalised() {
		return typeLocalised;
	}

	public String getPowerplayOrigin() {
		return powerplayOrigin;
	}

	public Integer getCount() {
		return count;
	}

	public Long getMissionID() {
		return missionID;
	}

	public Boolean getAbondoned() {
		return abondoned;
	}

}
