package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.material.Encoded;
import com.github.ChristopheCVB.EliteDangerous.models.material.Manufactured;
import com.github.ChristopheCVB.EliteDangerous.models.material.Material;

import java.util.List;

public class MaterialsEvent extends Event {
    public List<Material> raw;
    public List<Manufactured> manufactured;
    public List<Encoded> encoded;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onMaterialsEventTriggered((MaterialsEvent) event);
        }

        void onMaterialsEventTriggered(MaterialsEvent materialsEvent);
    }
}
