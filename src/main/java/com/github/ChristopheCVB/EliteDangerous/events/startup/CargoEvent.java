package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.CargoInventory;

import java.util.ArrayList;

public class CargoEvent extends Event {
	public String vessel;
	public Integer count;
	public ArrayList<CargoInventory> inventory;
}
