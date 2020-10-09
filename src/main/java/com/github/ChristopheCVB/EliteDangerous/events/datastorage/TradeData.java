/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/12/2020 11:29
*/

package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class TradeData {
	
	private String material, materialLocalised, category, categoryLocalised;
	private Integer quantity;
	
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
