package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum AtmosphereCompositionType {
	Water("Water"),
	Oxygen("Oxygen"),
	Carbon_Dioxide("CarbonDioxide"),
	Sulphur_Dioxide("SulphurDioxide"),
	Ammonia("Ammonia"),
	Methane("Methane"),
	Nitrogen("Nitrogen"),
	Hydrogen("Hydrogen"),
	Helium("Helium"),
	Neon("Neon"),
	Argon("Argon"),
	Silicates("Silicates"),
	Iron("Iron");

	private String identifier;

	AtmosphereCompositionType(String identifier) {
		this.identifier = identifier;
	}

	public String getAtmosphereCompositionTypeIdentifier() {
		return this.identifier;
	}

	public String getAtmosphereCompositionTypeName(String identifier) {
		String name = "null";
		for (AtmosphereCompositionType atmosphereCompositionType : values()) {
			if (atmosphereCompositionType.getAtmosphereCompositionTypeIdentifier().equals(identifier)) {
				name = atmosphereCompositionType.name().replaceAll("_", " ").replaceAll("\\$", "-");
			}
		}
		return name;
	}
}
