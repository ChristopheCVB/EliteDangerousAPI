package com.christophecvb.elitedangerous.events.startup;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.FuelCapacity;
import com.christophecvb.elitedangerous.models.Module;

import java.util.List;

public class LoadoutEvent extends Event {
    public String ship;
    public Integer shipID;
    public String shipName;
    public String shipIdent;
    public Integer hullValue;
    public Integer modulesValue;
    public Integer rebuy;
    public FuelCapacity fuelCapacity;
    public Integer cargoCapacity;
    public Double hullHealth;
    public Double maxJumpRange;
    public Double unladenMass;
    public String hot;
    public List<Module> modules;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onLoadoutEventTriggered((LoadoutEvent) event);
        }

        void onLoadoutEventTriggered(LoadoutEvent loadoutEvent);
    }
}
