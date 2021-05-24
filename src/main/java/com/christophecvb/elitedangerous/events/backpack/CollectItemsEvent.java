package com.christophecvb.elitedangerous.events.backpack;

import com.christophecvb.elitedangerous.events.Event;

public class CollectItemsEvent extends Event {
    public String name;
    public String type;
    public Long ownerID;
    public Integer count;
    public Boolean stolen;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStatusEventTriggered((CollectItemsEvent) event);
        }

        void onStatusEventTriggered(CollectItemsEvent statusEvent);
    }
}
