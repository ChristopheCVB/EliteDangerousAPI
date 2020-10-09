package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.*;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;

import java.util.List;

public class ScanEvent extends Event {
	
	private String scanType, bodyName, starType, luminosity, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, starSystem;
	private Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude, massEM, surfaceGravity,
	surfacePressure;
	private Integer bodyID, subclass;
	private Long radius, semiMajorAxis, orbitalPeriod, ageMY, systemAddress;
	private Boolean tidalLock, landable, star, wasMapped, wasDiscovered;
	private List<Parent> parents;
	private List<AtmosphereComposition> atmosphereComposition;
	private List<Ring> rings;
	private List<Material> materials;
	private List<Composition> composition;
	
	public ScanEvent(String timestamp, JsonObject jsonEvent) {
        super(timestamp);

        this.star = jsonEvent.has("StarType");
        this.starSystem = JsonUtils.pullString(jsonEvent, "StarSystem");
        this.scanType = JsonUtils.pullString(jsonEvent, "ScanType");
        this.bodyName = JsonUtils.pullString(jsonEvent, "BodyName");
        this.distanceFromArrivalLS = JsonUtils.pullDouble(jsonEvent, "DistanceFromArrivalLS");
        this.eccentricity = JsonUtils.pullDouble(jsonEvent, "Eccentricity");
        this.orbitalInclination = JsonUtils.pullDouble(jsonEvent, "OrbitalInclination");
        this.periapsis = JsonUtils.pullDouble(jsonEvent, "Periapsis");
        this.rotationPeriod = JsonUtils.pullDouble(jsonEvent, "RotationPeriod");
        this.axialTilt = JsonUtils.pullDouble(jsonEvent, "AxialTilt");
        this.bodyID = JsonUtils.pullInt(jsonEvent, "BodyID");
        this.radius = JsonUtils.pullLong(jsonEvent, "Radius");
        this.semiMajorAxis = JsonUtils.pullLong(jsonEvent, "SemiMajorAxis");
        this.orbitalPeriod = JsonUtils.pullLong(jsonEvent, "OrbitalPeriod");
        this.surfaceTemperature = JsonUtils.pullDouble(jsonEvent, "SurfaceTemperature");
        this.parents = GameFilesUtils.createParentList(JsonUtils.pullJsonArray(jsonEvent, "Parents"));
        this.rings = GameFilesUtils.createRingsList(JsonUtils.pullJsonArray(jsonEvent, "Rings"));
        this.absoluteMagnitude = JsonUtils.pullDouble(jsonEvent, "AbsoluteMagnitude");
        this.wasDiscovered = JsonUtils.pullBoolean(jsonEvent, "WasDiscovered");
        this.systemAddress = JsonUtils.pullLong(jsonEvent, "SystemAddress");

        // Star
        this.starType = JsonUtils.pullString(jsonEvent, "StarType");
        this.luminosity = JsonUtils.pullString(jsonEvent, "Luminosity");
        this.stellarMass = JsonUtils.pullDouble(jsonEvent, "StellarMass");
        this.ageMY = JsonUtils.pullLong(jsonEvent, "Age_MY");

        // Planet
        this.terraformState = JsonUtils.pullString(jsonEvent, "TerraformState");
        this.wasMapped = JsonUtils.pullBoolean(jsonEvent, "WasMapped");
        this.subclass = JsonUtils.pullInt(jsonEvent, "Subclass");
        this.planetClass = JsonUtils.pullString(jsonEvent, "PlanetClass");
        this.atmosphere = JsonUtils.pullString(jsonEvent, "Atmosphere");
        this.atmosphereType = JsonUtils.pullString(jsonEvent, "AtmosphereType");
        this.atmosphereComposition = jsonEvent.has("AtmosphereComposition") ? GameFilesUtils.createAtmosphereCompositionList(JsonUtils.pullJsonArray(jsonEvent, "AtmosphereComposition")) : null;
        this.volcanism = JsonUtils.pullString(jsonEvent, "Volcanism");
        this.reserveLevel = JsonUtils.pullString(jsonEvent, "ReserveLevel");
        this.massEM = JsonUtils.pullDouble(jsonEvent, "MassEM");
        this.surfaceGravity = JsonUtils.pullDouble(jsonEvent, "SurfaceGravity");
        this.surfacePressure = JsonUtils.pullDouble(jsonEvent, "SurfacePressure");
        this.tidalLock = JsonUtils.pullBoolean(jsonEvent, "TidalLock");
        this.landable = JsonUtils.pullBoolean(jsonEvent, "Landable");
        this.materials = GameFilesUtils.createMaterialList(JsonUtils.pullJsonArray(jsonEvent, "Materials"));
        this.composition = GameFilesUtils.createCompositionList(JsonUtils.pullJsonObject(jsonEvent, "Composition"));

        GameFilesUtils.isAllEventDataProcessed(this, jsonEvent);
    }
	
	public ScanInfo getInfo() {
		if(star) {
			return new StarScan(scanType, bodyName, starType, luminosity, distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod,
					axialTilt, absoluteMagnitude, bodyID, radius, semiMajorAxis, orbitalPeriod, ageMY, parents, rings, wasDiscovered, starSystem, systemAddress);
		}
		
		return new PlanetScan(scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, distanceFromArrivalLS, massEM, surfaceGravity,
				surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, bodyID, radius, semiMajorAxis, orbitalPeriod, tidalLock, landable,
				parents, atmosphereComposition, rings, materials, composition, wasMapped, wasDiscovered, starSystem, subclass, systemAddress);
	}

	public String getScanType() {
		return scanType;
	}

}
