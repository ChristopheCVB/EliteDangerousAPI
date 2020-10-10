package com.github.ChristopheCVB.EliteDangerous.events.fleetcarrier;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CarrierBankTransferEvent extends Event {
	
	private Long deposit, carrierId, playerBalance, carrierBalance;

	public CarrierBankTransferEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.deposit = JsonUtils.pullLong(jsonEvent, "Deposit");
        this.carrierId = JsonUtils.pullLong(jsonEvent, "CarrierID");
        this.playerBalance = JsonUtils.pullLong(jsonEvent, "PlayerBalance");
        this.carrierBalance = JsonUtils.pullLong(jsonEvent, "CarrierBalance");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public Long getDeposit() {
		return deposit;
	}

	public Long getCarrierId() {
		return carrierId;
	}

	public Long getPlayerBalance() {
		return playerBalance;
	}

	public Long getCarrierBalance() {
		return carrierBalance;
	}
	
}
