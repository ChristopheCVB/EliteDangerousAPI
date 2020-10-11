package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.localiser.Reputation;

public class ReputationEvent extends Event {
	public Double empire, federation, alliance, independent;

	public String getEmpireReputationReadable() {
		return Reputation.getReputationReadable(this.empire);
	}

	public String getFederationReputationReadable() {
		return Reputation.getReputationReadable(this.federation);
	}

	public String getAllianceReputationReadable() {
		return Reputation.getReputationReadable(this.alliance);
	}
	
	public String getIndependentReputationReadable() {
		return Reputation.getReputationReadable(independent);
	}
	
}
