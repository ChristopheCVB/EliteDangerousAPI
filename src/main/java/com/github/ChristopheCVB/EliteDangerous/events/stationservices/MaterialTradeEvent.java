/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:23
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.TradeData;

public class MaterialTradeEvent extends Event {
	public Long marketID;
	public String traderType;
	public TradeData paid;
	public TradeData received;

	public MaterialTradeEvent(String timestamp) {
        super(timestamp);
    }
}
