package com.github.ChristopheCVB.EliteDangerous.events.travel;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.Conflict;
import com.github.ChristopheCVB.EliteDangerous.events.models.Faction;

import java.util.List;

public class FSDJumpEvent extends Event {
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
	public Long population;
	public Long systemAddress;
	public Long boostUsed;
	public Integer bodyId;
	public Double jumpDistance;
	public Double fuelUsed;
	public Double fuelLevel;
	public List<Faction> factions;
	public List<Conflict> conflicts;
	public Double[] starPos;
	public List<String> powers;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onFSDJumpEventTriggered((FSDJumpEvent) event);
		}

		void onFSDJumpEventTriggered(FSDJumpEvent fsdJumpEvent);
	}
}
