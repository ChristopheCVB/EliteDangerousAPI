package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;

import java.util.ArrayList;

public class StarScan implements ScanInfo {
	public String scanType, bodyName, starType, luminosity, starSystem;
	public Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude;
	public Integer bodyID;
	public Long radius, semiMajorAxis, orbitalPeriod, ageMY, systemAddress;
	public ArrayList<Parent> parents;
	public ArrayList<Ring> rings;
	public Boolean wasDiscovered;

	public StarScan(String scanType, String bodyName, String starType, String luminosity, Double distanceFromArrivalLS,
					Double stellarMass, Double surfaceTemperature, Double eccentricity, Double orbitalInclination,
					Double periapsis, Double rotationPeriod, Double axialTilt, Double absoluteMagnitude, Integer bodyID,
					Long radius, Long semiMajorAxis, Long orbitalPeriod, Long ageMY, ArrayList<Parent> parents, ArrayList<Ring> rings,
					Boolean wasDiscovered, String starSystem, Long systemAddress) {
		this.scanType = scanType;
		this.bodyName = bodyName;
		this.starType = starType;
		this.systemAddress = systemAddress;
		this.luminosity = luminosity;
		this.distanceFromArrivalLS = distanceFromArrivalLS;
		this.stellarMass = stellarMass;
		this.surfaceTemperature = surfaceTemperature;
		this.eccentricity = eccentricity;
		this.orbitalInclination = orbitalInclination;
		this.periapsis = periapsis;
		this.rotationPeriod = rotationPeriod;
		this.axialTilt = axialTilt;
		this.absoluteMagnitude = absoluteMagnitude;
		this.bodyID = bodyID;
		this.radius = radius;
		this.semiMajorAxis = semiMajorAxis;
		this.orbitalPeriod = orbitalPeriod;
		this.ageMY = ageMY;
		this.parents = parents;
		this.rings = rings;
		this.wasDiscovered = wasDiscovered;
		this.starSystem = starSystem;
	}
}
