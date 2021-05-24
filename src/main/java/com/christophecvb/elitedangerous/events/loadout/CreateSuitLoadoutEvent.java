package com.christophecvb.elitedangerous.events.loadout;

import com.christophecvb.elitedangerous.models.LoadoutModule;

import java.util.ArrayList;

public class CreateSuitLoadoutEvent extends LoadoutEvent {
    public ArrayList<LoadoutModule> modules;
}
