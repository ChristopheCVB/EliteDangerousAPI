package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum PlanetClass {
	
	Metal_Rich_Body("Metal rich body"), High_Metal_Content_Body("High metal content body"), Rocky_Body("Rocky body"), Icy_Body("Icy body"),	Rocky_Ice_Body("Rocky ice body"), Earthlike_Body("Earthlike body"),	Water_World("Water world"), Ammonia_World("Ammonia world"), Water_Giant("Water giant"), Water_Giant_with_Life("Water giant with life"),
	Gas_Giant_with_Water_based_Life("Gas giant with water based life"), Gas_Giant_with_Ammonia_based_Life("Gas giant with ammonia based life"), 
	Sudarsky_Class_I_Gas_Giant("Sudarsky class I gas giant"), Sudarsky_Class_II_Gas_Giant("Sudarsky class II gas giant"), Sudarsky_Class_III_Gas_Giant("Sudarsky class III gas giant"),
	Sudarsky_Class_IV_Gas_Giant("Sudarsky class IV gas giant"), Sudarsky_Class_V_Gas_Giant("Sudarsky class V gas giant"), Helium_Rich_Gas_Giant("Helium rich gas giant"),
	Helium_Gas_Giant("Helium gas giant");
	
	private String planetClassName;
	
	 PlanetClass(String identifier) {
		planetClassName = identifier;
	}
	
	public String getPlanetClassIdentifiers() {
		return planetClassName;
	} 
	
	public String getPlanetClassName(String identifier) {
		String name = "null";
		for(PlanetClass planetClass : values()) {
			if(planetClass.getPlanetClassIdentifiers().equals(identifier)) {
				name = planetClass.name().replace("_", " ");
				name = planetClass.name().replace("$", "-");
			}
		}
		return name;
	}

}
