package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Conflict;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Faction;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class FSDJumpEvent extends Event {
	public String starSystem;
	public String systemAllegiance;
	public String systemEconomy;
	@SerializedName("SystemEconomy_Localised")
	public String systemEconomyLocalised;
	public String systemSecondEconomy;
	@SerializedName("SystemSecondEconomy_Localised")
	public String systemSecondEconomyLocalised;
	public String systemGovernment;
	@SerializedName("SystemGovernment_Localised")
	public String systemGovernmentLocalised;
	public String systemSecurity;
	@SerializedName("SystemSecurity_Localised")
	public String systemSecurityLocalised;
	public String body;
	public String bodyType;
	public String powerplayState;
	public Faction systemFaction;
	public Long population;
	public Long systemAddress;
	public Long boostUsed;
	public Integer bodyId;
	public Double jumpDistance;
	public Double fuelUsed;
	public Double fuelLevel;
	public ArrayList<Faction> factions;
	public ArrayList<Conflict> conflicts;
	public Double[] starPos;
	public ArrayList<String> powers;

	public FSDJumpEvent(String timestamp) {
		super(timestamp);
    }
}
