package com.github.ChristopheCVB.EliteDangerous.events.startup;

import com.github.ChristopheCVB.EliteDangerous.EliteDangerousAPI;
import com.github.ChristopheCVB.EliteDangerous.events.Event;
import com.github.ChristopheCVB.EliteDangerous.models.CargoItem;
import com.github.ChristopheCVB.EliteDangerous.utils.GameFiles;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class CargoEvent extends Event {
    public String vessel;
    public Integer count;
    public List<CargoItem> inventory;

    public interface Listener extends Event.Listener {
        @Override
        default <T extends Event> void onTriggered(T event) {
            this.onCargoEventTriggered((CargoEvent) event);
        }

        void onCargoEventTriggered(CargoEvent cargoEvent);
    }

    public static CargoEvent loadFromFile() {
        CargoEvent cargoEvent = null;

        File cargoFile = GameFiles.getCargoFile();
        if (cargoFile != null && cargoFile.exists()) {
            try {
                cargoEvent = EliteDangerousAPI.GSON.fromJson(String.join("", Files.readAllLines(cargoFile.toPath(), StandardCharsets.UTF_8)), CargoEvent.class);
            }
            catch (IOException ignored) {}
        }

        return cargoEvent;
    }
}
