package com.christophecvb.elitedangerous.events.loadout;

import java.util.ArrayList;

public class CreateSuitLoadoutEvent extends LoadoutBaseEvent {
    public ArrayList<SwitchSuitLoadoutEvent.Module> modules;
}
