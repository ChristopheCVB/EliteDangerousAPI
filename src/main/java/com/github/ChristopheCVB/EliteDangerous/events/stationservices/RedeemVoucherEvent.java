package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.bounty.FactionBounty;

import java.util.List;

public class RedeemVoucherEvent extends Event {
	public String type;
	public Long totalAmount;
	public Integer brokerPercentage;
	public List<FactionBounty> factions;
	
	public RedeemVoucherEvent(String timestamp) {
        super(timestamp);
    }
}
