package com.christophecvb.elitedangerous.events.suit;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.LoadoutModule;

import java.util.ArrayList;

public class SwitchSuitLoadoutEvent extends SuitLoadoutEvent {
    public ArrayList<LoadoutModule> modules;
    public ArrayList<String> suitMods;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSwitchSuitLoadoutEventTriggered((SwitchSuitLoadoutEvent) event);
        }

        void onSwitchSuitLoadoutEventTriggered(SwitchSuitLoadoutEvent vehicleSwitchEvent);
    }
}
