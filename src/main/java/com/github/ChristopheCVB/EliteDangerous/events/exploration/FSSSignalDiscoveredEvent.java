package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class FSSSignalDiscoveredEvent extends Event {
	public String signalName;
	public String signalNameLocalised;
	@SerializedName("USSType")
	public String ussType;
	@SerializedName("USSType_Localised")
	public String ussTypeLocalised;
	public String spawningState;
	public String spawningStateLocalised;
	public String spawningFaction;
	public String spawningFactionLocalised;
	public Integer threatLevel;
	public Long systemAddress;
	public Double timeRemaining;
	public Boolean isStation;
}
