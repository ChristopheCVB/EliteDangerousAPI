package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;

import java.util.ArrayList;

public class PlanetScan implements ScanInfo {
	public String scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, starSystem;
	public Double distanceFromArrivalLS, massEM, surfaceGravity, surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt;
	public Integer bodyID, subclass;
	public Long radius, semiMajorAxis, orbitalPeriod, systemAddress;
	public Boolean tidalLock, landable, wasMapped, wasDiscovered;
	public ArrayList<Parent> parents;
	public ArrayList<AtmosphereItem> atmosphereComposition;
	public ArrayList<Ring> rings;
	public ArrayList<Material> materials;
	public Composition composition;

	public PlanetScan(String scanType, String bodyName, String terraformState, String planetClass, String atmosphere,
					  String atmosphereType, String volcanism, String reserveLevel, Double distanceFromArrivalLS, Double massEM,
					  Double surfaceGravity, Double surfaceTemperature, Double surfacePressure, Double eccentricity,
					  Double orbitalInclination, Double periapsis, Double rotationPeriod, Double axialTilt, Integer bodyID,
					  Long radius, Long semiMajorAxis, Long orbitalPeriod, Boolean tidalLock, Boolean landable, ArrayList<Parent> parents,
					  ArrayList<AtmosphereItem> atmosphereComposition, ArrayList<Ring> rings, ArrayList<Material> materials,
					  Composition composition, Boolean wasMapped, Boolean wasDiscovered, String starSystem, Integer subclass, Long systemAddress) {
		this.scanType = scanType;
		this.subclass = subclass;
		this.systemAddress = systemAddress;
		this.bodyName = bodyName;
		this.terraformState = terraformState;
		this.planetClass = planetClass;
		this.atmosphere = atmosphere;
		this.atmosphereType = atmosphereType;
		this.volcanism = volcanism;
		this.reserveLevel = reserveLevel;
		this.distanceFromArrivalLS = distanceFromArrivalLS;
		this.massEM = massEM;
		this.surfaceGravity = surfaceGravity;
		this.surfaceTemperature = surfaceTemperature;
		this.surfacePressure = surfacePressure;
		this.eccentricity = eccentricity;
		this.orbitalInclination = orbitalInclination;
		this.periapsis = periapsis;
		this.rotationPeriod = rotationPeriod;
		this.axialTilt = axialTilt;
		this.bodyID = bodyID;
		this.radius = radius;
		this.semiMajorAxis = semiMajorAxis;
		this.orbitalPeriod = orbitalPeriod;
		this.tidalLock = tidalLock;
		this.landable = landable;
		this.parents = parents;
		this.atmosphereComposition = atmosphereComposition;
		this.rings = rings;
		this.materials = materials;
		this.composition = composition;
		this.wasMapped = wasMapped;
		this.wasDiscovered = wasDiscovered;
		this.starSystem = starSystem;
	}
}
