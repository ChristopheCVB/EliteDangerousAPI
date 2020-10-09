package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CargoDepotEvent extends Event{
	
	private Long missionID, startMarketID, endMarketID;
	private Integer count, itemCollected, itemsDelivered, totalItemsToDeliver;
	private String updateType, cargoType;
	private Double progress;
	
	public CargoDepotEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.missionID = JsonUtils.pullLong(jsonEvent, "MissionID");
        this.startMarketID = JsonUtils.pullLong(jsonEvent, "StartMarketID");
        this.endMarketID = JsonUtils.pullLong(jsonEvent, "EndMarketID");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");
        this.itemCollected = JsonUtils.pullInt(jsonEvent, "ItemCollected");
        this.itemsDelivered = JsonUtils.pullInt(jsonEvent, "ItemDelivered");
        this.totalItemsToDeliver = JsonUtils.pullInt(jsonEvent, "TotalItemsToDeliver");
        this.updateType = JsonUtils.pullString(jsonEvent, "UpdateType");
        this.cargoType = JsonUtils.pullString(jsonEvent, "CargoType");
        this.progress = JsonUtils.pullDouble(jsonEvent, "Progress");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getMissionID() {
		return missionID;
	}

	public Long getStartMarketID() {
		return startMarketID;
	}

	public Long getEndMarketID() {
		return endMarketID;
	}

	public Integer getCount() {
		return count;
	}

	public Integer getItemCollected() {
		return itemCollected;
	}

	public Integer getItemsDelivered() {
		return itemsDelivered;
	}

	public Integer getTotalItemsToDeliver() {
		return totalItemsToDeliver;
	}

	public String getUpdateType() {
		return updateType;
	}

	public String getCargoType() {
		return cargoType;
	}

	public Double getProgress() {
		return progress;
	}

}
