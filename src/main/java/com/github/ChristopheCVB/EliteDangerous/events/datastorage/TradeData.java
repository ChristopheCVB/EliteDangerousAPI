/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:29
*/

package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import com.google.gson.annotations.SerializedName;

public class TradeData {

	//TODO: here you have Localised again but you dont see what to put in the @SerializedName can you do this?
	public String material;
	public String materialLocalised;
	public String category;
	public String categoryLocalised;
	public Integer quantity;
	
	public TradeData(String material, String materialLocalised, String category, String categoryLocalised,
			Integer quantity) {
		this.material = material;
		this.materialLocalised = materialLocalised;
		this.category = category;
		this.categoryLocalised = categoryLocalised;
		this.quantity = quantity;
	}

	public String getMaterial() {
		return material;
	}

	public String getMaterialLocalised() {
		return materialLocalised;
	}

	public String getCategory() {
		return category;
	}

	public String getCategoryLocalised() {
		return categoryLocalised;
	}

	public Integer getQuantity() {
		return quantity;
	}

}
