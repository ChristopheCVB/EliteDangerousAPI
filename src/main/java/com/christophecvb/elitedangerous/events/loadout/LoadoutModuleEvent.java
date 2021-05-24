package com.christophecvb.elitedangerous.events.loadout;

public abstract class LoadoutModuleEvent extends LoadoutEvent {
    public String slotName;
    public String moduleName;
    public Long suitModuleID;
}
