package com.github.ChristopheCVB.EliteDangerous.events.exploration;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.scan.AtmosphereItem;
import com.github.ChristopheCVB.EliteDangerous.models.scan.Composition;
import com.github.ChristopheCVB.EliteDangerous.models.scan.Material;
import com.github.ChristopheCVB.EliteDangerous.models.scan.Parent;

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
