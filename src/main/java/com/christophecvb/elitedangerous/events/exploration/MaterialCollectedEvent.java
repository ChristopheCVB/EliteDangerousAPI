package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;

public class MaterialCollectedEvent extends Event {
    public String category, name;
    public String nameLocalised;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMaterialCollectedEventTriggered((MaterialCollectedEvent) event);
        }

        void onMaterialCollectedEventTriggered(MaterialCollectedEvent materialCollectedEvent);
    }
}
