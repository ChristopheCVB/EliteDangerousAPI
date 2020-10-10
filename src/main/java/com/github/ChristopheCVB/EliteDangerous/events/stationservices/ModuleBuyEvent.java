/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 14:15
*/

package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class ModuleBuyEvent extends Event {
	
	public String slot;
	public String storedItem;
	@SerializedName("StoredItem_Localised")
	public String storedItemLocalised;
	public String buyItem;
	@SerializedName("BuyItem_Localised")
	public String buyItemLocalised;
	public String ship;
	public String sellItem;
	@SerializedName("SellItem_Localised")
	public String sellItemLocalised;
	public Long buyPrice;
	public Long marketId;
	public Long sellPrice;
	public Integer shipId;
	
	public ModuleBuyEvent(String timestamp) {
		super(timestamp);
    }
}
