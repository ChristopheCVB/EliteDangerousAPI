package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Modifier;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.Ingredient;

import java.util.List;

public class EngineerCraftEvent extends Event {
	public String engineer;
	public String blueprintName;
	public String slot;
	public String module;
	public Integer engineerID;
	public Integer blueprintID;
	public Integer level;
	public Double quality;
	public List<Ingredient> ingredients;
	public List<Modifier> modifiers;

	public interface Listener extends Event.Listener {
		@Override
		default <T extends Event> void onTriggered(T event) {
			this.onEngineerCraftEventTriggered((EngineerCraftEvent) event);
		}

		void onEngineerCraftEventTriggered(EngineerCraftEvent engineerCraftEvent);
	}
}
