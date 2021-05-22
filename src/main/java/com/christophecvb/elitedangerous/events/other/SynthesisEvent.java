package com.christophecvb.elitedangerous.events.other;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.material.Material;

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
