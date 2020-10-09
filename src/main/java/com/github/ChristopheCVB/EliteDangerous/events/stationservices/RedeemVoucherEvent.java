/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/14/2020 06:32
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.FactionBounty;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class RedeemVoucherEvent extends Event {
	
	private String type;
	private Long totalAmount;
	private Integer brokerPercentage;
	private List<FactionBounty> factionBounties;
	
	public RedeemVoucherEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.totalAmount = JsonUtils.pullLong(jsonEvent, "Amount");
        this.brokerPercentage = JsonUtils.pullInt(jsonEvent, "BrokerPercentage");
        this.factionBounties = GameFilesUtils.createFactionBountyList(JsonUtils.pullJsonArray(jsonEvent, "Factions"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getType() {
		return type;
	}

	public Long getTotalAmount() {
		return totalAmount;
	}

	public Integer getBrokerPercentage() {
		return brokerPercentage;
	}

	public List<FactionBounty> getFactionBounties() {
		return factionBounties;
	}

}
