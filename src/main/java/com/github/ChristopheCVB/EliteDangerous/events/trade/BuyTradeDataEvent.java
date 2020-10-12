package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class BuyTradeDataEvent extends Event {
	public String system;
	public Integer cost;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onBuyTradeDataEventTriggered((BuyTradeDataEvent) event);
		}

		void onBuyTradeDataEventTriggered(BuyTradeDataEvent buyTradeDataEvent);
	}
}
