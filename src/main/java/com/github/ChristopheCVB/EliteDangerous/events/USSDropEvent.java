package com.github.ChristopheCVB.EliteDangerous.events;

import com.google.gson.annotations.SerializedName;

public class USSDropEvent extends Event {
    @SerializedName("USSType")
    public String ussType;
    @SerializedName("USSType_Localised")
    public String ussTypeLocalised;
    @SerializedName("USSThreat")
    public Integer ussThreat;
}
