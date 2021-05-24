package com.christophecvb.elitedangerous.events.suit;

import com.christophecvb.elitedangerous.models.LoadoutModule;

import java.util.ArrayList;

public class SwitchSuitLoadoutEvent extends SuitLoadoutEvent {
    public ArrayList<LoadoutModule> modules;
}
