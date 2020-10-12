package com.github.ChristopheCVB.EliteDangerous.utils.enums;

public enum BodyType {
	Null("Null"),
	Star("Star"),
	Planet("Planet"),
	Planetary_Ring("PlanetaryRing"),
	Stellar_Ring("StellarRing"),
	Station("Station"),
	Asteroid_Cluster("AsteroidCluster");

	private String identifier;

	BodyType(String identifier) {
		this.identifier = identifier;
	}

	public String getBodyTypeIdentifier() {
		return this.identifier;
	}

	public String getBodyTypeName(String identifier) {
		String name = "null";
		for (BodyType bodyType : values()) {
			if (bodyType.getBodyTypeIdentifier().equals(identifier)) {
				name = bodyType.name().replaceAll("_", " ").replaceAll("\\$", "-");
			}
		}
		return name;
	}
}
