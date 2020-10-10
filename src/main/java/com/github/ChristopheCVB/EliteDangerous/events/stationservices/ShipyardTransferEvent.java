package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class ShipyardTransferEvent extends Event {
	
	private String shipType, shipTypeLocalised, system;
	private Integer shipId;
	private Long shipMarketId, transferPrice, transferTime, marketId;
	private Double distance;
	
	public ShipyardTransferEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

        this.shipType = JsonUtils.pullString(jsonEvent, "ShipType");
        this.shipTypeLocalised = JsonUtils.pullString(jsonEvent, "ShipType_Localised");
        this.system = JsonUtils.pullString(jsonEvent, "System");
        this.shipId = JsonUtils.pullInt(jsonEvent, "ShipID");
        this.shipMarketId = JsonUtils.pullLong(jsonEvent, "ShipMarketID");
        this.transferPrice = JsonUtils.pullLong(jsonEvent, "TransferPrice");
        this.transferTime = JsonUtils.pullLong(jsonEvent, "TransferTime");
        this.marketId = JsonUtils.pullLong(jsonEvent, "MarketID");
        this.distance = JsonUtils.pullDouble(jsonEvent, "Distance");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getShipType() {
		return shipType;
	}

	public String getShipTypeLocalised() {
		return shipTypeLocalised;
	}

	public String getSystem() {
		return system;
	}

	public Integer getShipId() {
		return shipId;
	}

	public Long getShipMarketId() {
		return shipMarketId;
	}

	public Long getTransferPrice() {
		return transferPrice;
	}

	public Long getTransferTime() {
		return transferTime;
	}

	public Long getMarketId() {
		return marketId;
	}

	public Double getDistance() {
		return distance;
	}

}
