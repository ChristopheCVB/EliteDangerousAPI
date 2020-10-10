/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:20
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class ModuleRetrieveEvent extends Event {
	
	public Long marketID;
	public String slot;
	public String retrievedItem;
	@SerializedName("RetrievedItem_Localised")
	public String retrievedItemLocalised;
	public String ship;
	public String swapOutItem;
	@SerializedName("SwapOutItem_Localised")
	public String swapOutItemLocalised;
	public Integer shipID;
	public Boolean hot;
	
	public ModuleRetrieveEvent(String timestamp) {
		super(timestamp);
    }
}
