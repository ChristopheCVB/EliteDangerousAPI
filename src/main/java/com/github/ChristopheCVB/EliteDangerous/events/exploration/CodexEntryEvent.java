package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class CodexEntryEvent extends Event {
	public String name;
	public String subCategory;
	@SerializedName("SubCategory_Localised")
	public String subCategoryLocalised;
	public String category;
	@SerializedName("Category_Localised")
	public String categoryLocalised;
	public String region;
	public String system;
	public Integer entryID;
	public Long systemAddress;
	public Boolean isNewEntry;
	public Boolean newTraitsDiscovered;
	public String[] traits;
	
	public CodexEntryEvent(String timestamp) {
		super(timestamp);
    }
}
