package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class UpgradeSuitEvent extends Event {
    public String name;
    public String nameLocalised;
    public Long suitID;
    @SerializedName("Class")
    public Integer suitClass;
    public Long cost;
}
