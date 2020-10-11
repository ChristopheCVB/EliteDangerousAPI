package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.FuelCapacity;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Module;

import java.util.ArrayList;

public class LoadoutEvent extends Event {
	public String ship;
	public String shipName;
	public String shipIdent;
	public Integer shipID;
	public Integer hullValue;
	public Integer moduleValue;
	public Integer rebuy;
	public FuelCapacity fuelCapacity;
	public Integer cargoCapacity;
	public Double hullHealth;
	public Double maxJumpRange;
	public Double unladenMass;
	public ArrayList<Module> modules;
}
