package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.events.datastorage.scan.*;
import com.github.ChristopheCVB.EliteDangerous.events.interfaces.ScanInfo;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.github.ChristopheCVB.EliteDangerous.utils.JsonUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ScanEvent extends Event {
	public String scanType, bodyName, starType, luminosity, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, starSystem;
	public Double distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, absoluteMagnitude, massEM, surfaceGravity, surfacePressure;
	public Integer bodyID, subclass;
	public Long radius, semiMajorAxis, orbitalPeriod;
	@SerializedName("Age_MY")
	public Long ageMY;
	public Long systemAddress;
	public Boolean tidalLock, landable, wasMapped, wasDiscovered;
	public ArrayList<Parent> parents;
	public ArrayList<AtmosphereItem> atmosphereComposition;
	public ArrayList<Ring> rings;
	public ArrayList<Material> materials;
	public Composition composition;

	public ScanInfo getInfo() {
		if(this.starType != null) {
			return new StarScan(scanType, bodyName, starType, luminosity, distanceFromArrivalLS, stellarMass, surfaceTemperature, eccentricity, orbitalInclination, periapsis, rotationPeriod,
					axialTilt, absoluteMagnitude, bodyID, radius, semiMajorAxis, orbitalPeriod, ageMY, parents, rings, wasDiscovered, starSystem, systemAddress);
		}
		
		return new PlanetScan(scanType, bodyName, terraformState, planetClass, atmosphere, atmosphereType, volcanism, reserveLevel, distanceFromArrivalLS, massEM, surfaceGravity,
				surfaceTemperature, surfacePressure, eccentricity, orbitalInclination, periapsis, rotationPeriod, axialTilt, bodyID, radius, semiMajorAxis, orbitalPeriod, tidalLock, landable,
				parents, atmosphereComposition, rings, materials, composition, wasMapped, wasDiscovered, starSystem, subclass, systemAddress);
	}
}
