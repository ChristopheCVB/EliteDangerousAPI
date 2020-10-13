package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.toreadable.Reputation;

public class ReputationEvent extends Event {
	public Double empire, federation, alliance, independent;

	public String getEmpireReputationReadable() {
		return Reputation.getReadableName(this.empire);
	}

	public String getFederationReputationReadable() {
		return Reputation.getReadableName(this.federation);
	}

	public String getAllianceReputationReadable() {
		return Reputation.getReadableName(this.alliance);
	}

	public String getIndependentReputationReadable() {
		return Reputation.getReadableName(independent);
	}

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onReputationEventTriggered((ReputationEvent) event);
		}

		void onReputationEventTriggered(ReputationEvent reputationEvent);
	}
}
