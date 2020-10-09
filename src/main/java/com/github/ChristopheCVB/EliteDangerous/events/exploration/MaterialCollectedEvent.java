package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

public class MaterialCollectedEvent extends Event {
	
	private String category, name, nameLocalised;
	private Integer count;
	
	public MaterialCollectedEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.category = JsonUtils.pullString(jsonEvent, "Category");
        this.name = JsonUtils.pullString(jsonEvent, "Name");
        this.nameLocalised = JsonUtils.pullString(jsonEvent, "Name_Localised");
        this.count = JsonUtils.pullInt(jsonEvent, "Count");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public Integer getCount() {
		return count;
	}

	public String getNameLocalised() {
		return nameLocalised;
	}
	
}
