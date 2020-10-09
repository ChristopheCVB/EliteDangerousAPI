package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class EngineerContributionEvent extends Event {
	
	private String engineer, type, commodity, faction, material;
	private Integer engineerID, quantity, totalQuantity;
	
	public EngineerContributionEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.engineer = JsonUtils.pullString(jsonEvent, "Engineer");
        this.type = JsonUtils.pullString(jsonEvent, "Type");
        this.commodity = JsonUtils.pullString(jsonEvent, "Commodity");
        this.faction = JsonUtils.pullString(jsonEvent, "Faction");
        this.material = JsonUtils.pullString(jsonEvent, "Material");
        this.engineerID = JsonUtils.pullInt(jsonEvent, "EngineerID");
        this.quantity = JsonUtils.pullInt(jsonEvent, "Quantity");
        this.totalQuantity = JsonUtils.pullInt(jsonEvent, "TotalQuantity");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getEngineer() {
		return engineer;
	}

	public String getType() {
		return type;
	}

	public String getCommodity() {
		return commodity;
	}

	public String getFaction() {
		return faction;
	}

	public String getMaterial() {
		return material;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

}
