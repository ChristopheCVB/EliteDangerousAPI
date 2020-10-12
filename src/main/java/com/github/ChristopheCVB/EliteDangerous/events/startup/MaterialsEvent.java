package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.material.Material;

import java.util.List;

public class MaterialsEvent extends Event {
	public List<Material> raw;
	public List<Material> manufactured;
	public List<Material> encoded;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onMaterialsEventTriggered((MaterialsEvent) event);
		}

		void onMaterialsEventTriggered(MaterialsEvent materialsEvent);
	}
}
