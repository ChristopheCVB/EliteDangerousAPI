package com.github.ChristopheCVB.EliteDangerous.events.combat;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

/**
 * This event is fired every time the player is under attack.
 * 
 */
public class UnderAttackEvent extends Event {
	
	private String target;
	
	public UnderAttackEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.target = JsonUtils.pullString(jsonEvent, "Target");

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }
	
	/**
	 * Gets the target that is getting shot: Fighter, Mothership or You.
	 * @return target Fighter, Mothership or You
	 */
	public String getTarget() {
		return target;
	}
	
}
