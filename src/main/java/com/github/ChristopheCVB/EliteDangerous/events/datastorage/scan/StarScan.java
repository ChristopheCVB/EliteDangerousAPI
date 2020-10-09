package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;

import java.util.List;

public class StarScan implements ScanInfo {

	private String scanType, bodyName, starType, luminosity, starSystem;
	private Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude;
	private Integer bodyID;
	private Long radius, semiMajorAxis, orbitalPeriod, ageMY, systemAddress;
	private List<Parent> parents;
	private List<Ring> rings;
	private Boolean wasDiscovered;

	public StarScan(String scanType, String bodyName, String starType, String luminosity, Double distanceFromArrivalLS,
			Double stellarMass, Double surfaceTemperature, Double eccentricity, Double orbitalInclination,
			Double periapsis, Double rotationPeriod, Double axialTilt, Double absoluteMagnitude, Integer bodyID,
			Long radius, Long semiMajorAxis, Long orbitalPeriod, Long ageMY, List<Parent> parents, List<Ring> rings,
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

	public String getScanType() {
		return scanType;
	}

	public String getBodyName() {
		return bodyName;
	}

	public String getStarType() {
		return starType;
	}

	public String getLuminosity() {
		return luminosity;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public Double getStellarMass() {
		return stellarMass;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public Double getEccentricity() {
		return eccentricity;
	}

	public Double getOrbitalInclination() {
		return orbitalInclination;
	}

	public Double getPeriapsis() {
		return periapsis;
	}

	public Double getRotationPeriod() {
		return rotationPeriod;
	}

	public Double getAxialTilt() {
		return axialTilt;
	}

	public Double getAbsoluteMagnitude() {
		return absoluteMagnitude;
	}

	public Integer getBodyID() {
		return bodyID;
	}

	public Long getRadius() {
		return radius;
	}

	public Long getSemiMajorAxis() {
		return semiMajorAxis;
	}

	public Long getOrbitalPeriod() {
		return orbitalPeriod;
	}

	public Long getAgeMY() {
		return ageMY;
	}

	public Long getSystemAddress() {
		return systemAddress;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public List<Ring> getRings() {
		return rings;
	}

	public Boolean getWasDiscovered() {
		return wasDiscovered;
	}

}
