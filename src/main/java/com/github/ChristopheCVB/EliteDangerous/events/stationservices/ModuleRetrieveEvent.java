package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class ModuleRetrieveEvent extends Event {
    public Long marketID;
    public String slot;
    public String retrievedItem;
    public String retrievedItemLocalised;
    public String ship;
    public String swapOutItem;
    public String swapOutItemLocalised;
    public Integer shipID;
    public Boolean hot;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onModuleRetrieveEventTriggered((ModuleRetrieveEvent) event);
        }

        void onModuleRetrieveEventTriggered(ModuleRetrieveEvent moduleRetrieveEvent);
    }
}
