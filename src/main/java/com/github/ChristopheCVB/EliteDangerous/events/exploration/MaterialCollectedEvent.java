package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class MaterialCollectedEvent extends Event {
	public String category, name;
	@SerializedName("Name_Localised")
	public String nameLocalised;
	public Integer count;
	
	public MaterialCollectedEvent(String timestamp) {
        super(timestamp);
    }
}
