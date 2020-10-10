package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import com.google.gson.annotations.SerializedName;

public class TradeData {
	public String material;
	@SerializedName("Material_Localised")
	public String materialLocalised;
	public String category;
	@SerializedName("Category_Localised")
	public String categoryLocalised;
	public Integer quantity;
}
