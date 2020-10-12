package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class FetchRemoteModuleEvent extends Event {
    public Integer storageSlots;
    public Integer serverId;
    public Integer transferCost;
    public Integer transferTime;
    public Integer shipId;
    public String storedItem;
    public String storedItemLocalised;
    public String ship;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onFetchRemoteModuleEventTriggered((FetchRemoteModuleEvent) event);
        }

        void onFetchRemoteModuleEventTriggered(FetchRemoteModuleEvent fetchRemoteModuleEvent);
    }
}
