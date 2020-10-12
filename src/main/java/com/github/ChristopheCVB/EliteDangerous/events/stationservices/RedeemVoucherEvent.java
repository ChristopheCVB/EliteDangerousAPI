package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.models.bounty.FactionBounty;

import java.util.List;

public class RedeemVoucherEvent extends Event {
	public String type;
	public Long totalAmount;
	public Integer brokerPercentage;
	public List<FactionBounty> factions;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onRedeemVoucherEventTriggered((RedeemVoucherEvent) event);
		}

		void onRedeemVoucherEventTriggered(RedeemVoucherEvent redeemVoucherEvent);
	}
}
