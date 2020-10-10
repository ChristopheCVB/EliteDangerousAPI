package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class FSSSignalDiscoveredEvent extends Event {
	public String signalName;
	@SerializedName("SignalName_Localised")
	public String signalNameLocalised;
	@SerializedName("USSType")
	public String ussType;
	@SerializedName("USSType_Localised")
	public String ussTypeLocalised;
	public String spawningState;
	@SerializedName("SpawningState_Localised")
	public String spawningStateLocalised;
	public String spawningFaction;
	@SerializedName("SpawningFaction_Localised")
	public String spawningFactionLocalised;
	public Integer threatLevel;
	public Long systemAddress;
	public Double timeRemaining;
	public Boolean isStation;
	
	public FSSSignalDiscoveredEvent(String timestamp) {
		super(timestamp);
    }
}
