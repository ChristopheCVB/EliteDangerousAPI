package com.github.ChristopheCVB.EliteDangerous.events.trade;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class EjectCargoEvent extends Event {
	
	public String type;
	@SerializedName("Type_Localised")
	public String typeLocalised;
	public String powerplayOrigin;
	public Integer count;
	public Long missionID;
	public Boolean abandoned;
	
	public EjectCargoEvent(String timestamp) {
        super(timestamp);
    }
}
