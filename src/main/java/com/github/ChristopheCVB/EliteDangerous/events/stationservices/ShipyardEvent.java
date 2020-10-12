package com.github.ChristopheCVB.EliteDangerous.events.stationservices;

import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFilesUtils;
import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class ShipyardEvent extends Event {
    public Long marketID;
    public String stationName, starSystem;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onShipyardEventTriggered((ShipyardEvent) event);
        }

        void onShipyardEventTriggered(ShipyardEvent shipyardEvent);
    }

    public static ShipyardEvent loadFromFile() {
        ShipyardEvent moduleInfoEvent = null;

        File shipyardFile = GameFilesUtils.getShipyardFile();
        if (shipyardFile != null && shipyardFile.exists()) {
            try {
                moduleInfoEvent = new Gson().fromJson(String.join("", Files.readAllLines(shipyardFile.toPath(), StandardCharsets.UTF_8)), ShipyardEvent.class);
            }
            catch (IOException ignored) {}
        }

        return moduleInfoEvent;
    }
}
