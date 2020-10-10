package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class CargoDepotEvent extends Event{
	
	public Long missionID;
	public Long startMarketID;
	public Long endMarketID;
	public Integer count;
	public Integer itemCollected;
	public Integer itemsDelivered;
	public Integer totalItemsToDeliver;
	public String updateType;
	public String cargoType;
	public Double progress;
	
	public CargoDepotEvent(String timestamp) {
		super(timestamp);
    }
}
