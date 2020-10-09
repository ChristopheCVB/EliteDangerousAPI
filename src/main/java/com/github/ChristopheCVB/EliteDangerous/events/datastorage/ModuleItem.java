/*
Author: XenoPyax
Discord: XenoPyax#5647
File created: 05/10/2020 10:46
*/

package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

public class ModuleItem {
	
	private String slot, name, nameLocalised, engineerModifications;
	private Boolean hot;
	private Integer engineeeredLevel;
	private Double quality;
	
	public ModuleItem(String slot, String name, String nameLocalised, String engineerModifications, Boolean hot,
			Integer engineeeredLevel, Double quality) {
		this.slot = slot;
		this.name = name;
		this.nameLocalised = nameLocalised;
		this.engineerModifications = engineerModifications;
		this.hot = hot;
		this.engineeeredLevel = engineeeredLevel;
		this.quality = quality;
	}

	public String getSlot() {
		return slot;
	}

	public String getName() {
		return name;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}

	public String getEngineerModifications() {
		return engineerModifications;
	}

	public Boolean getHot() {
		return hot;
	}

	public Integer getEngineeeredLevel() {
		return engineeeredLevel;
	}

	public Double getQuality() {
		return quality;
	}

}
