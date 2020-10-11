package com.github.ChristopheCVB.EliteDangerous.events.inventory;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.inventory.Transfer;

import java.util.ArrayList;

public class CargoTransferEvent extends Event {
	public ArrayList<Transfer> transfers;
}
