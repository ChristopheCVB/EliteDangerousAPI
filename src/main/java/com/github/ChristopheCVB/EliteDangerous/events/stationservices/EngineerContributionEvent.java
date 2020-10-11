package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class EngineerContributionEvent extends Event {
	public String engineer;
	public String type;
	public String commodity;
	public String faction;
	public String material;
	public Integer engineerID;
	public Integer quantity;
	public Integer totalQuantity;
}
