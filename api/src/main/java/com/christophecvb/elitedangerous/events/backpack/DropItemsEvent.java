package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;

public class DropItemsEvent extends Event {
    public String name;
    public String type;
    public Long ownerID;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStatusEventTriggered((DropItemsEvent) event);
        }

        void onStatusEventTriggered(DropItemsEvent statusEvent);
    }
}
