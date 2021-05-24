package com.christophecvb.elitedangerous.events.suit;

import com.christophecvb.elitedangerous.models.LoadoutModule;

import java.util.ArrayList;

public class CreateSuitLoadoutEvent extends SuitLoadoutEvent {
    public ArrayList<LoadoutModule> modules;
}
