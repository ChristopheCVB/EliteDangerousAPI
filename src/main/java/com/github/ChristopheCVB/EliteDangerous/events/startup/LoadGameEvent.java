package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class LoadGameEvent extends Event {
	
	public String commander;
	public String FID;
	public String ship;
	public String shipLocalised;
	public String shipName;
	public String shipIdent;
	public String gameMode;
	public String group;
	public Integer shipId;
	public Double fuelLevel;
	public Double fuelCapacity;
	public Long credits;
	public Long loan;
	public Boolean horizons;
	
	public LoadGameEvent(String timestamp) {
		super(timestamp);
    }
}
