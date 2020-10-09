package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class CodexEntryEvent extends Event {
	
	private String name, subCategory, subCategoryLocalised, category, categoryLocalised, region, system;
	private Integer entryID;
	private Long systemAdress;
	private Boolean isNewEntry, newTraitsDiscovered;
	private String[] traits;
	
	public CodexEntryEvent(String timestamp, JsonObject jsonEvent) {
		super(timestamp);

		this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.subCategory = JsonUtils.pullString(jsonEvent, "SubCategory");
        this.subCategoryLocalised = JsonUtils.pullString(jsonEvent, "SubCategory_Localised");
        this.category = JsonUtils.pullString(jsonEvent, "Category");
        this.categoryLocalised = JsonUtils.pullString(jsonEvent, "Category_Localised");
        this.region = JsonUtils.pullString(jsonEvent, "Region");
        this.system = JsonUtils.pullString(jsonEvent, "System");
        this.entryID = JsonUtils.pullInt(jsonEvent, "EntryID");
        this.systemAdress = JsonUtils.pullLong(jsonEvent, "SystemAddress");
        this.isNewEntry = JsonUtils.pullBoolean(jsonEvent, "IsNewEntry");
        this.newTraitsDiscovered = JsonUtils.pullBoolean(jsonEvent, "NewTraitsDiscovered");
        this.traits = GameFilesUtils.createTraitsList(JsonUtils.pullJsonArray(jsonEvent, "Traits"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getName() {
		return name;
	}

	public String getSubCategory() {
		return subCategory;
	}

	public String getSubCategoryLocalised() {
		return subCategoryLocalised;
	}

	public String getCategory() {
		return category;
	}

	public String getCategoryLocalised() {
		return categoryLocalised;
	}

	public String getRegion() {
		return region;
	}

	public String getSystem() {
		return system;
	}

	public Integer getEntryID() {
		return entryID;
	}

	public Long getSystemAdress() {
		return systemAdress;
	}

	public Boolean getIsNewEntry() {
		return isNewEntry;
	}

	public Boolean getNewTraitsDiscovered() {
		return newTraitsDiscovered;
	}

	public String[] getTraits() {
		return traits;
	}

}
