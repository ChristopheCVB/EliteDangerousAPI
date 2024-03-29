package com.christophecvb.elitedangerous.events.fleetcarriers;

import com.christophecvb.elitedangerous.events.Event;

public class CarrierBankTransferEvent extends Event {

  public Long deposit, whithdraw, carrierID, playerBalance, carrierBalance;

  public interface Listener extends Event.Listener {

    @Override
    default <T extends Event> void onTriggered(T event) {
      this.onCarrierBankTransferEventTriggered((CarrierBankTransferEvent) event);
    }

    void onCarrierBankTransferEventTriggered(CarrierBankTransferEvent carrierBankTransferEvent);
  }
}
