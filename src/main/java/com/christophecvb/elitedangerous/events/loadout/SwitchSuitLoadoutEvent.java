package com.christophecvb.elitedangerous.events.loadout;

import java.util.ArrayList;

public class SwitchSuitLoadoutEvent extends LoadoutBaseEvent {
    public ArrayList<Module> modules;

    public static class Module {
        public String slotName;
        public Long suitModuleID;
        public String moduleName;
    }
}
