package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public abstract class DockEvent extends Event {
    @SerializedName("ID")
    public String id;
}
