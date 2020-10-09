package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum VolcanismClass {
	
	None("None"), Water_Magma("Water Magma"), Sulphur_Dioxide_Magma("Sulphur Dioxide Magma"), Ammonia_Magma("Ammonia Magma"),	Methane_Magma("Methane Magma"),	Nitrogen_Magma("Nitrogen Magma"),
	Silicate_Magma("Silicate Magma"), Metallic_Magma("Metallic Magma"),	Water_Geysers("Water Geysers"), Carbon_dioxide_Geysers("Carbon Dioxide Geysers"), Ammonia_Geysers("Ammonia Geysers"),
	Methane_Geysers("Methane Geysers"),	Nitrogen_Geysers("Nitrogen Geysers"), Helium_Geysers("Helium Geysers"),	Silicate_Vapour_Geysers("Silicate Vapour Geysers");
	
	private String volcanismClassName;
	
	VolcanismClass(String identifier) {
		volcanismClassName = identifier;
	}
	
	public String getVolcanismClassIdentifiers() {
		return volcanismClassName;
	} 
	
	public String getVolcanismClassName(String identifier) {
		String name = "null";
		for(VolcanismClass volcanismClass : values()) {
			if(volcanismClass.getVolcanismClassIdentifiers().equals(identifier)) {
				name = volcanismClass.name().replace("_", " ");
				name = volcanismClass.name().replace("$", "-");
			}
		}
		return name;
	}
	
}
