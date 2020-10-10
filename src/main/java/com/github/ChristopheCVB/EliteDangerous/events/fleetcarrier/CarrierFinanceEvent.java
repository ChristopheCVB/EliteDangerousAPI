package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CarrierFinanceEvent extends Event {
	
	private Double taxRate, reservePercent;
	private Long carrierId, carrierBalance, reserveBalance, availableBalance;
	
	public CarrierFinanceEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.taxRate = JsonUtils.pullDouble(jsonEvent, "TaxRate");
        this.reservePercent = JsonUtils.pullDouble(jsonEvent, "ReservePercent");
        this.carrierId = JsonUtils.pullLong(jsonEvent, "CarrierID");
        this.carrierBalance = JsonUtils.pullLong(jsonEvent, "CarrierBalance");
        this.reserveBalance = JsonUtils.pullLong(jsonEvent, "ReserveBalance");
        this.availableBalance = JsonUtils.pullLong(jsonEvent, "AvailableBalance");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Double getTaxRate() {
		return taxRate;
	}

	public Double getReservePercent() {
		return reservePercent;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public Long getCarrierBalance() {
		return carrierBalance;
	}

	public Long getReserveBalance() {
		return reserveBalance;
	}

	public Long getAvailableBalance() {
		return availableBalance;
	}

}
