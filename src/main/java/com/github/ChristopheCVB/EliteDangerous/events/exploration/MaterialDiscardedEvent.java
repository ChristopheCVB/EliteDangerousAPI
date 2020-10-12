package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;

public class MaterialDiscardedEvent extends Event {
    public String category, name;
    public Integer count;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMaterialDiscardedEventTriggered((MaterialDiscardedEvent) event);
        }

        void onMaterialDiscardedEventTriggered(MaterialDiscardedEvent materialDiscardedEvent);
    }
}
