package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StationEconomy;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class DockedEvent extends Event {
	
	public String stationName;
	public String stationType;
	public String starSystem;
	public String stationFactionName;
	public String stationFactionState;
	public String stationGovernment;
	@SerializedName("StationGovernment_Localised")
	public String stationGovernmentLocalised;
	public String stationAllegiance;
	public String stationEconomy;
	@SerializedName("StationEconomy_Localised")
	public String stationEconomyLocalised;
	public ArrayList<StationEconomy> stationEconomies;
	public Long systemAddress;
	public Long marketID;
	public Double distFromStarLS;
	public Boolean activeFine;
	public ArrayList<String> stationServices;

	public DockedEvent(String timestamp) {
		super(timestamp);
    }
}
