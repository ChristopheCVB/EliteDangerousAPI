package com.github.ChristopheCVB.EliteDangerous.events.inventory;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory.Transfer;

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
