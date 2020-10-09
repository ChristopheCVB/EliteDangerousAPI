package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum BodyType {
	
	Null("Null"), Star("Star"), Planet("Planet"), Planetary_Ring("PlanetaryRing"), Stellar_Ring("StellarRing"), Station("Station"), Asteriod_Cluster("AsteroidCluster");
	
	private String bodyTypeName;
	
	BodyType(String identifier) {
		bodyTypeName = identifier;
	}
	
	public String getBodyTypeIdentifiers() {
		return bodyTypeName;
	} 
	
	public String getBodyTypeName(String identifier) {
		String name = "null";
		for(BodyType bodyType : values()) {
			if(bodyType.getBodyTypeIdentifiers().equals(identifier)) {
				name = bodyType.name().replace("_", " ");
				name = bodyType.name().replace("$", "-");
			}
		}
		return name;
	}

}
