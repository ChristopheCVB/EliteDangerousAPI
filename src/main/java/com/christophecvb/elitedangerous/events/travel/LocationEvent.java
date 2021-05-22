package com.christophecvb.elitedangerous.events.travel;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.Conflict;
import com.christophecvb.elitedangerous.models.Faction;
import com.christophecvb.elitedangerous.models.StationEconomy;

import java.util.List;

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
	private List<Faction> factions;
	private List<Conflict> conflicts;
	private List<String> powers, stationServices;
	private List<StationEconomy> stationEconomies;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onLocationEventTriggered((LocationEvent) event);
		}

		void onLocationEventTriggered(LocationEvent locationEvent);
	}
}
