package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.localiser.Reputation;
import com.google.gson.JsonObject;

/**
 * @author Xeno Pyax
 *
 */
public class ReputationEvent extends Event {

	private Integer empire, federation, alliance, independent;

	public ReputationEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        if (jsonEvent.has("Empire")) {
            this.empire = JsonUtils.pullDouble(jsonEvent, "Empire").intValue();
            this.federation = JsonUtils.pullDouble(jsonEvent, "Federation").intValue();
            this.alliance = JsonUtils.pullDouble(jsonEvent, "Alliance").intValue();
            this.independent = JsonUtils.pullInt(jsonEvent, "Independent");
        }

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	/**
	 * Get Empire Reputation as an Integer between -100 an +100.
	 * 
	 * @return empire Reputation as integer.
	 */
	public Integer getEmpireReputation() {
		return empire;
	}
	
	/**
	 * Get Empire reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getEmpireReputationLocalised() {
		return Reputation.getReputationLocalised(empire);
	}

	/**
	 * Get Federation reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getFederationReputation() {
		return federation;
	}
	
	/**
	 * Get Federation reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getFederationReputationLocalised() {
		return Reputation.getReputationLocalised(federation);
	}

	/**
	 * Get Alliance reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getAllianceReputation() {
		return alliance;
	}
	
	/**
	 * Get Alliance reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getAllianceReputationLocalised() {
		return Reputation.getReputationLocalised(alliance);
	}
	
	/**
	 * Get Independent reputation as an Integer between -100 an +100.
	 * 
	 * @return Integer Reputation as integer.
	 */
	public Integer getIndependentReputation() {
		return independent;
	}
	
	/**
	 * Get Independent reputation as localized String.
	 * 
	 * @return String Reputation Name.
	 */
	public String getIndependentReputationLocalised() {
		return Reputation.getReputationLocalised(independent);
	}
	
}
