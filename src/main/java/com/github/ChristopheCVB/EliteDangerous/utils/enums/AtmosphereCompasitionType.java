package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum AtmosphereCompasitionType {
	
	Water("Water"), Oxygen("Oxygen"), Carbon_Dioxide("CarbonDioxide"), Sulphur_Dioxide("SulphurDioxide"), Ammonia("Ammonia"), Methane("Methane"), Nitrogen("Nitrogen"),
	Hydrogen("Hydrogen"), Helium("Helium"), Neon("Neon"), Argon("Argon"), Silicates("Silicates"), Iron("Iron");
	
	private String atmosphereCompasitionType;
	
	AtmosphereCompasitionType(String identifier) {
		atmosphereCompasitionType = identifier;
	}
	
	public String getAtmosphereCompasitionTypeIdentifiers() {
		return atmosphereCompasitionType;
	} 
	
	public String getAatmosphereCompasitionTypeName(String identifier) {
		String name = "null";
		for(AtmosphereCompasitionType atmosphereCompasitionType : values()) {
			if(atmosphereCompasitionType.getAtmosphereCompasitionTypeIdentifiers().equals(identifier)) {
				name = atmosphereCompasitionType.name().replace("_", " ");
				name = atmosphereCompasitionType.name().replace("$", "-");
			}
		}
		return name;
	}

}
