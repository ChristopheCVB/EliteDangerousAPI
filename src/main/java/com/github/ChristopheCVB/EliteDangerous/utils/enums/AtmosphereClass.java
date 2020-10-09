package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum AtmosphereClass {
	
	No_Atmosphere("No atmosphere"), Suitable_for_water$based_Life("Suitable for water-based life"), Ammonia_and_Oxygen("Ammonia and oxygen"), Ammonia("Ammonia"), Water("Water"),
	Carbon_dioxide("Carbon dioxide"), Sulphur_dioxide("Sulphur dioxide"), Nitrogen("Nitrogen"), Water$rich("Water-rich"), Methane$rich("Methane-rich"), Ammonia$rich("Ammonia-rich"),
	Carbon_dioxide$rich("Carbon dioxide-rich"), Methane("Methane"), Helium("Helium"), Silicate_vapour("Silicate vapour"), Metallic_vapour("Metallic vapour"), Neaon$rich("Neon-rich"),
	Argon$rich("Argon-rich"), Neon("Neon"), Argon("Argon"), Oxygen("Oxygen");
	
	private String atmosphereClassName;
	
	AtmosphereClass(String identifier) {
		atmosphereClassName = identifier;
	}
	
	public String getAtmosphereClassIdentifiers() {
		return atmosphereClassName;
	} 
	
	public String getAtmosphereClassName(String identifier) {
		String name = "null";
		for(AtmosphereClass atmosphereClass : values()) {
			if(atmosphereClass.getAtmosphereClassIdentifiers().equals(identifier)) {
				name = atmosphereClass.name().replace("_", " ").replace("$", "-");
			}
		}
		return name;
	}

}
