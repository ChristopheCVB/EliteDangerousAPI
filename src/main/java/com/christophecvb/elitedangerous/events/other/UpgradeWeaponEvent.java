package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class UpgradeWeaponEvent extends Event {
    public String name;
    public String suitModuleID;
    @SerializedName("Class")
    public Integer weaponClass;
    public Long cost;
}
