package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Modifier;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.Ingredient;
import com.google.gson.JsonObject;

import java.util.ArrayList;

public class EngineerCraftEvent extends Event {
	public String engineer;
	public String blueprintName;
	public String slot;
	public String module;
	public Integer engineerID;
	public Integer blueprintID;
	public Integer level;
	public Double quality;
	public ArrayList<Ingredient> ingredients;
	public ArrayList<Modifier> modifiers;
}
