package com.christophecvb.elitedangerous.events.suit;

import com.christophecvb.elitedangerous.events.Event;
import com.google.gson.annotations.SerializedName;

public class UpgradeWeaponEvent extends Event {
    public String name;
    public String nameLocalised;
    public Long suitModuleID;
    @SerializedName("Class")
    public Integer weaponClass;
    public Long cost;
}
