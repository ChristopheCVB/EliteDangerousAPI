package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class FSSSignalDiscoveredEvent extends Event {

	private String signalName, signalName_Localised, USSType, USSType_Localised, spawningState, spawningState_Localised, spawningFaction, spawningFaction_Localised;
	private Integer threatLevel;
	private Long systemAddress;
	private Double timeRemaining;
	private Boolean isStation;
	
	public FSSSignalDiscoveredEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.signalName = JsonUtils.pullString(jsonEvent, "SignalName");
		this.signalName_Localised = JsonUtils.pullString(jsonEvent, "SignalName_Localised");
        this.USSType = JsonUtils.pullString(jsonEvent, "USSType");
        this.USSType_Localised = JsonUtils.pullString(jsonEvent, "USSType_Localised");
        this.spawningState = JsonUtils.pullString(jsonEvent, "SpawningState");
        this.spawningState_Localised = JsonUtils.pullString(jsonEvent, "SpawningState_Localised");
        this.spawningFaction = JsonUtils.pullString(jsonEvent, "SpawningFaction");
        this.spawningFaction_Localised = JsonUtils.pullString(jsonEvent, "SpawningFaction_Localised");
        this.threatLevel = JsonUtils.pullInt(jsonEvent, "ThreatLevel");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.timeRemaining = JsonUtils.pullDouble(jsonEvent, "TimeRemaining");
        this.isStation = JsonUtils.pullBoolean(jsonEvent, "IsStation");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSignalName() {
		return signalName;
	}

	public String getSignalName_Localised() {
		return signalName_Localised;
	}

	public String getUSSType() {
		return USSType;
	}

	public String getUSSType_Localised() {
		return USSType_Localised;
	}

	public String getSpawningState() {
		return spawningState;
	}

	public String getSpawningState_Localised() {
		return spawningState_Localised;
	}

	public String getSpawningFaction() {
		return spawningFaction;
	}

	public String getSpawningFaction_Localised() {
		return spawningFaction_Localised;
	}

	public Integer getThreatLevel() {
		return threatLevel;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Double getTimeRemaining() {
		return timeRemaining;
	}

	public Boolean getIsStation() {
		return isStation;
	}

}
