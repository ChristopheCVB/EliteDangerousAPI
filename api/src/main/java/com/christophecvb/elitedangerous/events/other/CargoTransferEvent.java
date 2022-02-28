package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.inventory.Transfer;

import java.util.List;

public class CargoTransferEvent extends Event {
    public List<Transfer> transfers;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCargoTransferEventTriggered((CargoTransferEvent) event);
        }

        void onCargoTransferEventTriggered(CargoTransferEvent cargoTransferEvent);
    }
}
