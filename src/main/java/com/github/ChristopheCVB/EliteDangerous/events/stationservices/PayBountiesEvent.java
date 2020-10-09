/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 20:49
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class PayBountiesEvent extends Event {
	
	private Long amount;
	private String faction, factionLocalised;
	private Integer shipId, brokerPercentage;
	
	public PayBountiesEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.amount = JsonUtils.pullLong(jsonEvent, "Amount");
        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.factionLocalised = JsonUtils.pullString(jsonEvent, "Faction_Localised");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.brokerPercentage = JsonUtils.pullInt(jsonEvent, "BrokerPercentage");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getAmount() {
		return amount;
	}

	public String getFaction() {
		return faction;
	}

	public String getFactionLocalised() {
		return factionLocalised;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Integer getBrokerPercentage() {
		return brokerPercentage;
	}

}
