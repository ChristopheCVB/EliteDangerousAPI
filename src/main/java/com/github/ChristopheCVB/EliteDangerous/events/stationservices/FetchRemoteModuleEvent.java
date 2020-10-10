package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FetchRemoteModuleEvent extends Event {
	public Integer storageSlots;
	public Integer serverId;
	public Integer transferCost;
	public Integer transferTime;
	public Integer shipId;
	public String storedItem;
	public String storedItemLocalised;
	public String ship;
	
	public FetchRemoteModuleEvent(String timestamp) {
        super(timestamp);
    }
}
