package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

public class HullDamageEvent extends Event {
	public Double health;
	public Boolean playerPilot;
	public Boolean fighter;
	
	public HullDamageEvent(String timestamp) {
        super(timestamp);
    }
}
