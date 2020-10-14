package com.github.ChristopheCVB.EliteDangerous.events.other;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.material.Material;

import java.util.List;

public class SynthesisEvent extends Event {
    public String name;
    public List<Material> materials;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onSynthesisEventTriggered((SynthesisEvent) event);
        }

        void onSynthesisEventTriggered(SynthesisEvent synthesisEvent);
    }
}
