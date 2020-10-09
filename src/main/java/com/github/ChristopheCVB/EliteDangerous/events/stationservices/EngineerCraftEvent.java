package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.Modifier;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.engineer.Ingredient;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class EngineerCraftEvent extends Event {
	
	private String engineer, blueprintName, slot, module;
	private Integer engineerID, blueprintID, level;
	private Double quality;
	private List<Ingredient> ingredients;
	private List<Modifier> modifiers;
	
	public EngineerCraftEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.module = JsonUtils.pullString(jsonEvent, "Module");
        this.slot = JsonUtils.pullString(jsonEvent, "Slot");
        this.engineer = JsonUtils.pullString(jsonEvent, "Engineer");
        this.blueprintName = JsonUtils.pullString(jsonEvent, "BlueprintName");
        this.engineerID = JsonUtils.pullInt(jsonEvent, "EngineerID");
        this.blueprintID = JsonUtils.pullInt(jsonEvent, "BlueprintID");
        this.level = JsonUtils.pullInt(jsonEvent, "Level");
        this.quality = JsonUtils.pullDouble(jsonEvent, "Quality");
        this.ingredients = GameFilesUtils.createIngredientsList(JsonUtils.pullJsonArray(jsonEvent, "Ingredients"));
        this.modifiers = GameFilesUtils.createModifierList(JsonUtils.pullJsonArray(jsonEvent, "Modifiers"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }

	public String getSlot() {
		return slot;
	}

	public String getModule() {
		return module;
	}

	public String getEngineer() {
		return engineer;
	}

	public String getBlueprintName() {
		return blueprintName;
	}

	public Integer getEngineerID() {
		return engineerID;
	}

	public Integer getBlueprintID() {
		return blueprintID;
	}

	public Integer getLevel() {
		return level;
	}

	public Double getQuality() {
		return quality;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public List<Modifier> getModifiers() {
		return modifiers;
	}

}
