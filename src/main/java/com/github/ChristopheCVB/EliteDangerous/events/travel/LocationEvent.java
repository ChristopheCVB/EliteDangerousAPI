package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Faction;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.StationEconomy;

import java.util.ArrayList;

public class LocationEvent extends Event {
	public String starSystem;
	public String systemAllegiance;
	public String systemEconomy;
	public String systemEconomyLocalised;
	public String systemSecondEconomy;
	public String systemSecondEconomyLocalised;
	public String systemGovernment;
	public String systemGovernmentLocalised;
	public String systemSecurity;
	public String systemSecurityLocalised;
	public String body;
	public String bodyType;
	public Faction systemFaction;
	public String powerplayState;
	public String stationName;
	public String stationType;
	public String stationEconomy;
	public Faction stationFaction;
	public String stationAllegiance;
	public String stationGovernment;
	public String stationEconomyLocalised;
	public String stationGovernmentLocalised;
	private Double[] starPos;
	private Long systemAddress, population, marketID;
	private Integer bodyID;
	private Boolean docked;
	private ArrayList<Faction> factions;
	private ArrayList<String> powers, stationServices;
	private ArrayList<StationEconomy> stationEconomies;
}
