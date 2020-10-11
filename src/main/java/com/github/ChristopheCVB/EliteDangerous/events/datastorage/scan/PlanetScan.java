package com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan;

import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;

import java.util.List;

public class PlanetScan implements ScanInfo {

	private String scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, starSystem;
	private Double distanceFromArrivalLS, massEM, surfaceGravity, surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt;
	private Integer bodyID, subclass;
	private Long radius, semiMajorAxis, orbitalPeriod, systemAddress;
	private Boolean tidalLock, landable, wasMapped, wasDiscovered;
	private List<Parent> parents;
	private List<AtmosphereItem> atmosphereComposition;
	private List<Ring> rings;
	private List<Material> materials;
	private List<Composition> composition;
	
	public PlanetScan(String scanType, String bodyName, String terraformState, String planetClass, String atmosphere,
                      String atmosphereType, String volcanism, String reserveLevel, Double distanceFromArrivalLS, Double massEM,
                      Double surfaceGravity, Double surfaceTemperature, Double surfacePressure, Double eccentricity,
                      Double orbitalInclination, Double periapsis, Double rotationPeriod, Double axialTilt, Integer bodyID,
                      Long radius, Long semiMajorAxis, Long orbitalPeriod, Boolean tidalLock, Boolean landable, List<Parent> parents,
                      List<AtmosphereItem> atmosphereComposition, List<Ring> rings, List<Material> materials,
                      List<Composition> composition, Boolean wasMapped, Boolean wasDiscovered, String starSystem, Integer subclass, Long systemAddress) {
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

	public String getScanType() {
		return scanType;
	}

	public String getBodyName() {
		return bodyName;
	}

	public String getTerraformState() {
		return terraformState;
	}

	public String getPlanetClass() {
		return planetClass;
	}

	public String getAtmosphere() {
		return atmosphere;
	}

	public String getAtmosphereType() {
		return atmosphereType;
	}

	public String getVolcanism() {
		return volcanism;
	}

	public String getReserveLevel() {
		return reserveLevel;
	}

	public String getStarSystem() {
		return starSystem;
	}

	public Double getDistanceFromArrivalLS() {
		return distanceFromArrivalLS;
	}

	public Double getMassEM() {
		return massEM;
	}

	public Double getSurfaceGravity() {
		return surfaceGravity;
	}

	public Double getSurfaceTemperature() {
		return surfaceTemperature;
	}

	public Double getSurfacePressure() {
		return surfacePressure;
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

	public Integer getBodyID() {
		return bodyID;
	}

	public Integer getSubclass() {
		return subclass;
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

	public Long getSystemAddress() {
		return systemAddress;
	}

	public Boolean getTidalLock() {
		return tidalLock;
	}

	public Boolean getLandable() {
		return landable;
	}

	public Boolean getWasMapped() {
		return wasMapped;
	}

	public Boolean getWasDiscovered() {
		return wasDiscovered;
	}

	public List<Parent> getParents() {
		return parents;
	}

	public List<AtmosphereItem> getAtmosphereComposition() {
		return atmosphereComposition;
	}

	public List<Ring> getRings() {
		return rings;
	}

	public List<Material> getMaterials() {
		return materials;
	}

	public List<Composition> getComposition() {
		return composition;
	}

}
