package com.github.ChristopheCVB.EliteDangerous.events.backpack;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.backpack.BackpackItem;

import java.util.List;

public class BackpackChangeEvent extends Event {
    public List<BackpackItem> added;
    public List<BackpackItem> removed;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onStatusEventTriggered((BackpackChangeEvent) event);
        }

        void onStatusEventTriggered(BackpackChangeEvent statusEvent);
    }
}
