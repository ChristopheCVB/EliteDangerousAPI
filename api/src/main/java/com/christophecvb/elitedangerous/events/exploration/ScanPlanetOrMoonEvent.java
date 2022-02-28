package com.christophecvb.elitedangerous.events.exploration;

import com.christophecvb.elitedangerous.events.Event;
import com.christophecvb.elitedangerous.models.scan.AtmosphereItem;
import com.christophecvb.elitedangerous.models.scan.Composition;
import com.christophecvb.elitedangerous.models.scan.Material;
import com.christophecvb.elitedangerous.models.scan.Parent;

import java.util.List;

public class ScanPlanetOrMoonEvent extends ScanEvent {
    public Double axialTilt;
    public String terraformState;
    public String planetClass;
    public String atmosphere;
    public String atmosphereType;
    public String volcanism;
    public String reserveLevel;
    public Double massEM;
    public Double surfaceGravity;
    public Double surfacePressure;
    public Integer subclass;
    public Boolean tidalLock;
    public Boolean landable;
    public List<Parent> parents;
    public List<AtmosphereItem> atmosphereComposition;
    public List<Material> materials;
    public Composition composition;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onScanPlanetOrMoonEventTriggered((ScanPlanetOrMoonEvent) event);
        }

        void onScanPlanetOrMoonEventTriggered(ScanPlanetOrMoonEvent scanPlanetOrMoonEvent);
    }
}
