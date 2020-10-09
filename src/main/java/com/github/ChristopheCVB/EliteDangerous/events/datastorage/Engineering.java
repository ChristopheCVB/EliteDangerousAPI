package com.github.ChristopheCVB.EliteDangerous.events.datastorage;

import java.util.List;

public class Engineering {
	
	private String engineer, blueprintName, experimentalEffect, experimentalEffectLocalised;
	private Integer engineerID, blueprintID, level;
	private Double quality;
	private List<Modifier> modifiers;
	
	public Engineering(String engineer, String blueprintName, String experimentalEffect,
			String experimentalEffectLocalised, Integer engineerID, Integer blueprintID, Integer level, Double quality,
			List<Modifier> modifiers) {
		this.engineer = engineer;
		this.blueprintName = blueprintName;
		this.experimentalEffect = experimentalEffect;
		this.experimentalEffectLocalised = experimentalEffectLocalised;
		this.engineerID = engineerID;
		this.blueprintID = blueprintID;
		this.level = level;
		this.quality = quality;
		this.modifiers = modifiers;
	}

	public String getEngineer() {
		return engineer;
	}

	public String getBlueprintName() {
		return blueprintName;
	}

	public String getExperimentalEffect() {
		return experimentalEffect;
	}

	public String getExperimentalEffectLocalised() {
		return experimentalEffectLocalised;
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

	public List<Modifier> getModifiers() {
		return modifiers;
	}

}
